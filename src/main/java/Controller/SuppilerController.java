/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DbHandler;
import Model.Inventory;
import Model.Supplier;
import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACE
 */
public class SuppilerController implements ActionListener {

    private DbHandler dbhand;
    private Supplier supp;
    private Main mf;
    
    public SuppilerController() {
        dbhand = new DbHandler();
        supp = new Supplier();
        mf = new Main();
    }
    

    public int suppid(){
        List a = dbhand.select("select max(suppilerid) from Supplier");
        System.out.println(a);
        System.out.println(a.toString().replaceAll("[\\[\\]]",""));
        
        if( !"null".equals(a.toString().replaceAll("[\\[\\]]","")))
        {
            System.out.println("There is a value");
            int b = Integer.parseInt(a.toString().replaceAll("[\\[\\]]",""))+1;
            System.out.println(b);
            //String c = Integer.toString(b);
            return b;
        }
        
        else{
            System.out.println("The selected value is null is check the database.");
            System.out.println("No record.");
            System.out.println("Returning 1 as employee number");
            //String itemidvalue = "1";
            //int b = Integer.parseInt(a.toString().replaceAll("[\\[\\]]",""));
            int c = 1;
            return c;
        }

        
    }
    
    public void displaysupId(JTable e){
        //         session = NewHibernateUtil.getSessionFactory().getCurrentSession();
//         session.beginTransaction(); 
//         Query create = session.createQuery("from Inventory");
//        
//         List product =  create.list();
//         session.getTransaction().commit();
        List product = dbhand.select("from Supplier");
       //session.getTransaction().commit();
        
         Vector<String> tableHeaders = new Vector<String>();
    
         tableHeaders.add("Supplier ID"); 
         tableHeaders.add("Supplier Name");
         tableHeaders.add("Supplier Address");
         tableHeaders.add("Supplier Contact");
    

         
         Vector tableData = new Vector();
         
         for(Object o: product)
         {
             Supplier suppe = (Supplier) o;
             Vector<Object> oneRow = new Vector<Object>();
       
        oneRow.add(suppe.getSuppilerid());
        oneRow.add(suppe.getSuppilername());
        oneRow.add(suppe.getAddress());
        oneRow.add(suppe.getAddress());
        tableData.add(oneRow);
    
    }
       e.setModel(new DefaultTableModel(tableData, tableHeaders));
             

    }
    
    public void insertsupp(){
        supp.setSuppilerid(Integer.parseInt(mf.getMf().getAdminform().getJtx_suppid().getText()));
        supp.setSuppilername(mf.getMf().getAdminform().getJtx_suppname().getText());
        supp.setAddress(mf.getMf().getAdminform().getJtx_suppadd().getText());
        supp.setContact(Integer.parseInt(mf.getMf().getAdminform().getJtx_suppcon().getText()));
        
        dbhand.insert(supp);
        
        displaysupId(mf.getMf().getAdminform().getJtb_supp());
    }
    public void updatesupp(){
        supp.setSuppilerid(Integer.parseInt(mf.getMf().getAdminform().getJtx_suppid().getText()));
        supp.setSuppilername(mf.getMf().getAdminform().getJtx_suppname().getText());
        supp.setAddress(mf.getMf().getAdminform().getJtx_suppadd().getText());
        supp.setContact(Integer.parseInt(mf.getMf().getAdminform().getJtx_suppcon().getText()));
        
        dbhand.update(supp);
        
        displaysupId(mf.getMf().getAdminform().getJtb_supp());
    }
    public void deletesupp(){
        supp.setSuppilerid(Integer.parseInt(mf.getMf().getAdminform().getJtx_suppid().getText()));
        supp.setSuppilername(mf.getMf().getAdminform().getJtx_suppname().getText());
        supp.setAddress(mf.getMf().getAdminform().getJtx_suppadd().getText());
        supp.setContact(Integer.parseInt(mf.getMf().getAdminform().getJtx_suppcon().getText()));
        
        dbhand.delete(supp);
        
        displaysupId(mf.getMf().getAdminform().getJtb_supp());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(mf.getMf().getAdminform().getBtn_suppin() == e.getSource()){
        insertsupp();
    }
    else if(mf.getMf().getAdminform().getBtn_suppup() == e.getSource()){
        updatesupp();
    }
    else if(mf.getMf().getAdminform().getBtn_suppde() == e.getSource()){
        deletesupp();
    }
    else{
        
    }
    
    
    }
    
    
    
    
}
