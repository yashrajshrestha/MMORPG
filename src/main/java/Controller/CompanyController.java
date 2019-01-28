/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Company;
import Model.DbHandler;
import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author ACE
 */
public class CompanyController implements ActionListener {
    
    private Company com;
    private DbHandler dbhand;
    private Main mf;
    
    

    public CompanyController() {
        com = new Company();
        dbhand = new DbHandler();
        mf = new Main();
    }
    
    
    public List<Company> cominfo(){
        return dbhand.select("from Company");
       
    }

    public Vector<Object> companyInfo(){
        //ArrayList<String> coma = new ArrayList<>();
//        for(Company comp: cominfo()){
//            
//            System.out.println("This is the company name.");
//            System.out.println(comp.getName());
//            System.out.println(comp.getId());
//            
//             coma.add(comp);
//            
////            mf.getMf().getAdminform().setComp_id(comp.getId());
////            
////            mf.getMf().getAdminform().setCompname(comp.getName());
////            
////            mf.getMf().getAdminform().setCompaddress(comp.getAddress());
////            
////            mf.getMf().getAdminform().setCompmail(comp.getEmail());
////            
////            mf.getMf().getAdminform().setCompcontact(comp.getNumber());
//        }     
//        return null;
       
//         Iterator al = cominfo().iterator();
//        while(al.hasNext()){
//            coma.add(al.next());
//        }
//        
//        return coma;
          //Vector tableData = new Vector();
         Vector<Object> oneRow = new Vector<Object>();
         for(Object o: cominfo())
         {
             Company comp =  (Company) o;
             
        oneRow.add(comp.getId());
        oneRow.add(comp.getName());
        oneRow.add(comp.getAddress());
        oneRow.add(comp.getEmail());
        oneRow.add(comp.getNumber());
        
         //       tableData.add(oneRow);
    }
       //  return tableData;
         return oneRow;  
    }
 
    public void change(){
    if(mf.getMf().getAdminform().getComp_id().getText().isEmpty())
    {
        //com.setId( Integer.parseInt(mf.getMf().getAdminform().getComp_id().getText()));
        com.setName( mf.getMf().getAdminform().getCompname().getText());
        com.setAddress(mf.getMf().getAdminform().getCompaddress().getText());
        com.setEmail(mf.getMf().getAdminform().getCompmail().getText());
        com.setNumber(Integer.parseInt(mf.getMf().getAdminform().getCompcontact().getText()));
        dbhand.insert(com);     
    }
    else{
        com.setId( Integer.parseInt(mf.getMf().getAdminform().getComp_id().getText()));
        com.setName( mf.getMf().getAdminform().getCompname().getText());
        com.setAddress(mf.getMf().getAdminform().getCompaddress().getText());
        com.setEmail(mf.getMf().getAdminform().getCompmail().getText());
        com.setNumber(Integer.parseInt(mf.getMf().getAdminform().getCompcontact().getText()));
        dbhand.update(com);
    }
       
}

    @Override
    public void actionPerformed(ActionEvent e) {
           if(mf.getMf().getAdminform().getBtn_Compudap() == e.getSource()){
               change();
               
           }
    }
    
    
            
    
}
