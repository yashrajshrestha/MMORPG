/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Billproduct;
import Model.DbHandler;
import Model.Inventory;
import Model.Transcation;
import View.BillForm;
import View.Main;
import View.SellingForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

/**
 *
 * @author ACE
 */
public class SellingController implements ActionListener {
    
    private Session session;
    private DbHandler dbhand;
    private Main mf;
    private Inventory invent;
    private Transcation trans;
    private Billproduct billpro;
 
    private ArrayList<Inventory> inventlist = new ArrayList<Inventory>() ;
    private ArrayList<Integer> medicineid = new ArrayList();
    private ArrayList<Billproduct> billproduct  = new  ArrayList<Billproduct>(); 
  
    
    
    public SellingController() {
        dbhand = new DbHandler();
        mf = new Main();
        trans = new Transcation();
   

        
            
    }
    
    public void billInfoRemove(){
        
      dbhand.select("truncate Billproduct");
    }
    
    private List<Inventory> inventories(){
        return dbhand.select("from Inventory");
       }
    
    public ArrayList<Integer> getmedicine(){       
        
        for(Inventory i: inventories())
        {
            medicineid.add(i.getInventoryid());
        }
        return medicineid; 
    }
    
    public void inputitem()
    {
        for(Inventory i: inventories())
        {
            if(Integer.parseInt(mf.getMf().getSellingForm().getItemBox().getSelectedItem().toString())==i.getInventoryid()){
              mf.getMf().getSellingForm().setItemname(i.getInventoryname());    
              mf.getMf().getSellingForm().setItemrate(i.getUnit());
        }
        }
        
    }
    
    
    private void clearRows(DefaultTableModel model){
        for(int i = model.getRowCount()-1;i>=0;i--){
        model.removeRow(i);
        }
    }
    
    private void clearTable(){
    DefaultTableModel dtm= (DefaultTableModel)mf.getMf().getSellingForm().getjTable2().getModel();
    clearRows(dtm);
    }
    
    
    
    
    private boolean hasproduct(DefaultTableModel dtm){
     
        for(int i=0;i<dtm.getRowCount();i++){
            if(Integer.parseInt(mf.getMf().getSellingForm().getItemBox().getSelectedItem().toString()) == Integer.parseInt(dtm.getValueAt(i, 0).toString())){
                return true;
            }
        }
        return false;
    }
    
    private void addproduct(DefaultTableModel dtm){
       
        double up= Double.parseDouble(mf.getMf().getSellingForm().getItemrate().getText());
        int qty;
                 
        for(int i=0;i<dtm.getRowCount();i++){
            if(Integer.parseInt(mf.getMf().getSellingForm().getItemBox().getSelectedItem().toString()) == Integer.parseInt(dtm.getValueAt(i, 0).toString())){
                qty=Integer.parseInt(dtm.getValueAt(i, 3).toString());
                dtm.setValueAt(Integer.parseInt(mf.getMf().getSellingForm().getItemquantity().getText())+qty, i, 3);
                double total=up*Integer.parseInt(dtm.getValueAt(i, 3).toString());
                dtm.setValueAt(total, i, 4);
            }
        }
    }
    
    
  
    
    public void additem(){
        DefaultTableModel dtm=(DefaultTableModel) mf.getMf().getSellingForm().getjTable2().getModel();
        
        if(mf.getMf().getSellingForm().getItemquantity().equals("")){
            JOptionPane.showMessageDialog(null, "Enter product qunatity");
        }
        
        else{
            invent = new Inventory();
            
            
            int a =0;
            int sold =0;
         
            for(Inventory o: inventories())
         {
            if(o.getInventoryid()== Integer.parseInt(mf.getMf().getSellingForm().getItemBox().getSelectedItem().toString()))
             {
             invent.setInventoryid(o.getInventoryid());
             //soldid = o.getInventoryid();
            
             
             invent.setInventoryname(o.getInventoryname());
             a = (int) o.getInventorydesc();
             invent.setManudate(o.getManudate());
             invent.setUnit(o.getUnit());
             invent.setExdate(o.getExdate());
             invent.setManufac(o.getManufac());
             invent.setSupplier(o.getSupplier());
             //invent.setTotalsold(o.getTotalsold());
             sold = o.getTotalsold();
             }
    }
            
            int c =  a;
                   
            System.out.println(c);  
            
            int plus = 0;
            
            for(int i=0;i<dtm.getRowCount();i++){
            if(Integer.parseInt(mf.getMf().getSellingForm().getItemBox().getSelectedItem().toString()) == Integer.parseInt(dtm.getValueAt(i, 0).toString())){  
                plus= (int) Double.parseDouble(dtm.getValueAt(i, 3).toString());
              
            }
        }
            
            int b = Integer.parseInt(mf.getMf().getSellingForm().getItemquantity().getText().toString())+plus;
                 
           
            if(b<c){
                double up= Double.parseDouble(mf.getMf().getSellingForm().getItemrate().getText())/*invent.getUnit()*/;
                int qty= Integer.parseInt(mf.getMf().getSellingForm().getItemquantity().getText())/*invent.getInventorydesc()*/;
                double total=up*qty;
                 
                Object obj[]={
                    Integer.parseInt(mf.getMf().getSellingForm().getItemBox().getSelectedItem().toString()),
                    mf.getMf().getSellingForm().getItemname().getText(),
                    Double.parseDouble(mf.getMf().getSellingForm().getItemrate().getText()),
                    Integer.parseInt(mf.getMf().getSellingForm().getItemquantity().getText()),total
                    };
                        
                    
                    if(hasproduct(dtm))
                    {
                     addproduct(dtm);
                    }
                    else
                    {
                    dtm.addRow(obj);
                    }
                        
                    
                    // Update's the stock in the inventory table
                 int e = (int) (c-b);
                 System.out.println("This is the minus value of the quantity");
                
                 System.out.println(e);
   
                 System.out.println(invent.getInventoryid());
                 System.out.println("----------------------");
               
                     
                 invent.setInventorydesc(e);
                 invent.setTotalsold(sold+b);
                 
                 inventlist.add(invent);
                 
                
         
                 invent = null;
                 
                
            } 
            else {
                  JOptionPane.showMessageDialog(null, "No enough qunatity in stock");    
            }
            
        }
    }
    
    public void sellsubmit(){

        DefaultTableModel dtm=(DefaultTableModel) mf.getMf().getSellingForm().getjTable2().getModel();

      for(int i=0;i<inventlist.size();i++){
          System.out.println(inventlist.get(i).getInventoryid());
          
      }
               
      
           double total = 0;
           
           for(int i=0;i<dtm.getRowCount();i++){
               
            total+=Double.parseDouble(dtm.getValueAt(i, 4).toString());
            mf.getMf().getSellingForm().getGrandtotal().setText(Double.toString(total));
             billpro = new Billproduct();
             billpro.setId((int) dtm.getValueAt(i, 0));
             billpro.setName((String) dtm.getValueAt(i, 1));
             billpro.setRate((double) dtm.getValueAt(i,2));
             billpro.setQty((int) dtm.getValueAt(i, 3));
             billpro.setTotal((double) dtm.getValueAt(i, 4));
             
             billproduct.add(billpro);
             billpro = null;
             
           }

    }
    
   public void pay(){
        if(mf.getMf().getSellingForm().getCustomername().getText().equals("") || mf.getMf().getSellingForm().getTotalpayment().getText().equals(""))
        {
        JOptionPane.showMessageDialog(null, "Enter all fields");
        }
        else if(Double.parseDouble( mf.getMf().getSellingForm().getGrandtotal().getText())<=Double.parseDouble( mf.getMf().getSellingForm().getTotalpayment().getText()))
        {
            
        //To calculate the change amount
        
        double a=Double.parseDouble(mf.getMf().getSellingForm().getGrandtotal().getText());
        double b=Double.parseDouble(mf.getMf().getSellingForm().getTotalpayment().getText());
        double c=b-a;
       
        
        //To get the values of purchased item from above table and store them in database
        

        trans.setCname(mf.getMf().getSellingForm().getCustomername().getText());
    
        
        trans.setTotal(a);
        trans.setPaytype((String)mf.getMf().getSellingForm().getPaybox().getSelectedItem());
        trans.setSalesperson(null);
        trans.setDate(null);
 
        
        try {
          
            dbhand.insert(trans);
            for(int i =0; i<inventlist.size(); i++) {
                inventlist.get(i).getTranscation().add(trans);
                trans.getInventory().add(inventlist.get(i));
 
                dbhand.update(inventlist.get(i));
                
            }
            
       //     billInfoRemove();
        
            for(int i=0;i<billproduct.size();i++){
                dbhand.delete(billproduct.get(i));
                dbhand.insert(billproduct.get(i));
            }
            
            
          
            
           JOptionPane.showMessageDialog(null, "Purchased Successful\n Change value ="+c);
        
        } 
        catch (Exception ex) {
        
            ex.printStackTrace();
        }

    }
   }
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e.getSource() == mf.getMf().getSellingForm().getItemBox())
       {
           inputitem();   
       }
       else if(e.getSource() == mf.getMf().getSellingForm().getBtn_add())
               {
                   additem();
               }
       else if(e.getSource() == mf.getMf().getSellingForm().getBtn_submit())
       {
           
//        if(btn_submit.isSelected()== true)
//        {
//            btn_submit.disable();
//        }
           sellsubmit();
           mf.getMf().getSellingForm().getBtn_submit().setEnabled(false);
       }
       
       else if(e.getSource() == mf.getMf().getSellingForm().getBtn_pay())
       {
           pay();
       }
       else if(e.getSource()== mf.getMf().getSellingForm().getBth_cancelitem())
       {
           clearTable();
       }

       else{
           System.out.println("error!!!");
       }
       
    }
    
    
}
