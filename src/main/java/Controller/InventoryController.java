/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.DbHandler;
import Model.Inventory;
import Model.NewHibernateUtil;

import Model.Supplier;
import View.InventoryForm;
import View.Main;
import View.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javafx.scene.control.Tab;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ACE
 */
public class InventoryController implements ActionListener{
    
         private Inventory med;
         private Supplier supplier;
         private DbHandler dbhand;
         private Main mf;
         private ArrayList<Integer> supid = new ArrayList<Integer>();
         
                 
         
         
         public InventoryController(){
             mf = new Main();
             med = new Inventory();
             dbhand = new DbHandler();
             supplier = new Supplier();
            
         }
     
         
         
         public List<Supplier> suppdetails(){
             return  dbhand.select("from Supplier");
         }
         
         
         public ArrayList<Integer> suppid(){
             for(Supplier i: suppdetails())
        {
            supid.add(i.getSuppilerid());
        }
        return supid; 
         }
         
         
         
         
         
          public void inputsupp()
    {
        for(Supplier i: suppdetails())
        {
            if(Integer.parseInt(mf.getMf().getInventoryForm().getSupp_box().getSelectedItem().toString())==i.getSuppilerid()){
                System.out.println(i.getSuppilername());
              mf.getMf().getInventoryForm().setSuppilername(i.getSuppilername());    
             
        }
        }
        
    }
         
      
        //    Insert Function of the Inventory        
              public void insertInventory() 
                {        
    DefaultTableModel dtm=(DefaultTableModel) mf.getMf().getInventoryForm().getItable().getModel();
        try{
            
           
                med.setInventoryname(mf.getMf().getInventoryForm().getText_name().getText());
                med.setInventorydesc(Double.parseDouble(mf.getMf().getInventoryForm().getText_qty().getText()));
                String mdate = String.format("%1$td-%1$tm-%1$tY", mf.getMf().getInventoryForm().getManudate().getDate());
                med.setManudate(mdate);
                med.setUnit(Double.parseDouble(mf.getMf().getInventoryForm().getProductrate().getText()));
               String date = String.format("%1$td-%1$tm-%1$tY", mf.getMf().getInventoryForm().getExpdate().getDate());
                med.setExdate(date);
                med.setManufac(mf.getMf().getInventoryForm().getManucomp().getText());
              
   
                for(Supplier i: suppdetails())
        {
            if(i.getSuppilerid() == Integer.parseInt(mf.getMf().getInventoryForm().getSupp_box().getSelectedItem().toString()))
   
                med.setSupplier(i);
        }
               
                dbhand.insert(med);
               
                
                displayproductinfo(mf.getMf().getInventoryForm().getItable());
                

                 
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        } 
    }
    
    
//    update function of the Inventory    
    public void updateInventory() 
{        
        try{
            
                med.setInventoryid(Integer.parseInt(mf.getMf().getInventoryForm().getText_id().getText()));
                med.setInventoryname(mf.getMf().getInventoryForm().getText_name().getText());
                med.setInventorydesc(Double.parseDouble(mf.getMf().getInventoryForm().getText_qty().getText()));
                String mdate = String.format("%1$td-%1$tm-%1$tY", mf.getMf().getInventoryForm().getManudate().getDate());
                med.setManudate(mdate);
                med.setUnit(Double.parseDouble(mf.getMf().getInventoryForm().getProductrate().getText()));
                String date = String.format("%1$td-%1$tm-%1$tY", mf.getMf().getInventoryForm().getExpdate().getDate());
                med.setExdate(date);
                med.setManufac(mf.getMf().getInventoryForm().getManucomp().getText());
                             for(Supplier i: suppdetails())
        {
            if(i.getSuppilerid() == Integer.parseInt(mf.getMf().getInventoryForm().getSupp_box().getSelectedItem().toString()))
          
                med.setSupplier(i);
        }
                dbhand.update(med);
                displayproductinfo(mf.getMf().getInventoryForm().getItable());
            
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        } 
        
    }
    
//     delete function of the inventory
    public void deleteInventory(){
        try{
             med.setInventoryid(Integer.parseInt(mf.getMf().getInventoryForm().getText_id().getText()));
            dbhand.delete(med);
            displayproductinfo(mf.getMf().getInventoryForm().getItable());
            //clearout();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    
    
    
    
    
 //  -----------------    All the select function of the inventory
    
    
    public int itemid(){
        List a = dbhand.select("select max(inventoryid) from Inventory");
        System.out.println(a);

        if( !"null".equals(a.toString().replaceAll("[\\[\\]]","")))
        {            
            int b = Integer.parseInt(a.toString().replaceAll("[\\[\\]]",""))+1;
            System.out.println(b);
            return b;   
        }
        else{
            System.out.println("The selected value is null is check the database.");
            System.out.println("No record.");           
            return 1;
        }
    }
    
    
    public void displayproductinfo(JTable e){
        List product = dbhand.select("from Inventory");
        
         Vector<String> tableHeaders = new Vector<String>();
    
         tableHeaders.add("Med ID"); 
         tableHeaders.add("Med Name");
         tableHeaders.add("Med qunatity");
         tableHeaders.add("Manufacture date");
         tableHeaders.add("product unit");
         tableHeaders.add("Expiry date");
         tableHeaders.add("Manufacture");
         tableHeaders.add("Suppilers");

         
         Vector tableData = new Vector();
         
         for(Object o: product)
         {
             Inventory invent = (Inventory) o;
             Vector<Object> oneRow = new Vector<Object>();
        oneRow.add(invent.getInventoryid());
              
        oneRow.add(invent.getInventoryname());
        oneRow.add(invent.getInventorydesc());
        oneRow.add(invent.getManudate());
        oneRow.add(invent.getUnit());
        oneRow.add(invent.getExdate());
        oneRow.add(invent.getManufac());
         oneRow.add(invent.getSupplier().getSuppilername());
        tableData.add(oneRow);
    }
          
       e.setModel(new DefaultTableModel(tableData, tableHeaders));
             
       
     }
    
    public void stockSearch(String e){
        List<Inventory> a = dbhand.select("from Inventory where inventoryname ='"+e+"'");
      
       DefaultTableModel dtm= (DefaultTableModel) mf.getMf().getStockForm().getjTable1().getModel();
       
       if(mf.getMf().getStockForm().getjTable1().getModel().getRowCount()>=1)
       {
       clearRows(dtm);
       }
       
        for(Inventory med : a)
        {
        Object[] medicine ={med.getInventoryid(),med.getInventoryname(),med.getInventorydesc(),med.getUnit(),med.getManudate(),med.getExdate(),med.getManufac(),med.getTotalsold()};
        dtm.addRow(medicine);
        }
        
    }
    
    private void clearRows(DefaultTableModel model){
        for(int i = model.getRowCount()-1;i>=0;i--){
        model.removeRow(i);
        }
    }
        
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == mf.getMf().getInventoryForm().getBtn_add())
        {
           insertInventory();
        }
        else if(e.getSource() == mf.getMf().getInventoryForm().getBtn_iupdate())
        {
            updateInventory();
        }
        else if(e.getSource() == mf.getMf().getInventoryForm().getBtn_idelete())
        {
            deleteInventory();
            
        }
                else if(e.getSource() == mf.getMf().getInventoryForm().getSupp_box()){
            inputsupp();
        }

        else if(e.getSource() == mf.getMf().getStockForm().getBtn_serach())
        {
            stockSearch(mf.getMf().getStockForm().getJtf_Mdname().getText());
        }
        
        else{
            System.out.println("not a command");
        }
    }    
}
