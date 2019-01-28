/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Billproduct;
import Model.Company;
import Model.DbHandler;
import Model.Inventory;
import Model.Transcation;
import View.BillForm;
import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACE
 */
public class BillController implements ActionListener {
   
    
    
    private DbHandler dbhand;
    //private List<Inventory> a;
    private Main mf;
    private Company comp;
    //private List<Transcation> bill;
    //private List<Billproduct> billpro;
    
    public BillController() {
        dbhand = new DbHandler();
        //a = dbhand.select("from Inventory");
        mf = new Main();
        comp = new Company();
        // bill = dbhand.select("from Transcation where t_id = (SELECT max(t_id) from Transcation)");
    
    }
    
    public List<Billproduct> billinfo(){
        return dbhand.select("from Billproduct");    
    }
    
    
          
    public List<Company> Companyinfo(){
        return dbhand.select("from Company");
    }
    
//    public void selectproduct(){
//        dbhand.select("select i.inventory name,i.inventory_id from Inventory i JOIN"
//                + "");
//    }
    
    public void billsdetails(){
              
         
           BillForm bill = new BillForm();
           bill.setVisible(true);
           bill.setLocation(450,100);
           bill.toFront();
           bill.setSize(500,800);
           
           bill.getJta_bill().append("\t\t Medicial store management system \n");
           for(Company i :Companyinfo())
           {
           bill.getJta_bill().append("\t\t"+i.getAddress()+"\n");
           bill.getJta_bill().append("\t\t"+i.getEmail()+"\n");
           bill.getJta_bill().append("\t\t"+i.getNumber()+"\n");
           bill.getJta_bill().append("Customer name:"+mf.getMf().getSellingForm().getCustomername().getText()+" \t\t\t Date:"+mf.getMf().getMain_date().getText()+" \n\n\n");
           }
           bill.getJta_bill().append("-----------------------------------------------------------------------------------------------------------------\n");
           bill.getJta_bill().append("Itemid \t Itemname \t\t QTY \t RATE \t Total\n");
           bill.getJta_bill().append("-----------------------------------------------------------------------------------------------------------------\n");
        for (Billproduct billpro1 : billinfo()) {
            bill.getJta_bill().append(""+billpro1.getId()+"\t"+billpro1.getName()+"\t\t"+billpro1.getQty()+"\t"+billpro1.getRate()+"\t"+billpro1.getTotal()+"\n");
        }
           bill.getJta_bill().append("-----------------------------------------------------------------------------------------------------------------\n");
           bill.getJta_bill().append("\t\t\t\t grand Total:"+mf.getMf().getSellingForm().getGrandtotal().getText()+"\n");
           bill.getJta_bill().append("-----------------------------------------------------------------------------------------------------------------\n");
         
           
    }
    
    public void date(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(mf.getMf().getSellingForm().getJbtn_print()== e.getSource()){
            billsdetails();
        }
    }
    
    
}
