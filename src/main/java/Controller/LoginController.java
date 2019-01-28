/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DbHandler;
import Model.Employee;
import Model.StaffLog;
import View.Login;
import View.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ACE
 */
public class LoginController implements ActionListener {
    private DbHandler dbhand;
    //private Login log;
    private StaffLog stafflog;
    private ArrayList<Employee> emp = new ArrayList<Employee>();
    private Main mf;        
    public LoginController() {
        dbhand = new DbHandler();
      //  log = new Login();
        stafflog = new StaffLog();
        mf = new Main();
    }
    
    
    public List<Employee> billinfo(){
        return dbhand.select("from Employee");
    }

    public boolean logincheck(){
     //List a = dbhand.select("select * from Employee where employeeName='"+log.getUsername()+"',password="+log.getPassword()+"'");
      
      for(Employee em: billinfo()){
          
          System.out.println(em.getEmpolyeeName()+" "+em.getPassword()+" "+mf.getLog().getUsername().getText()+" "+mf.getLog().getLogin_password().getText());
          
          if(em.getEmpolyeeName().equals(mf.getLog().getUsername().getText())&&em.getPassword().equals(mf.getLog().getLogin_password().getText()))
              
          {
              //System.out.println("");
              //System.out.println("added");
              emp.add(em);
              System.out.println(emp.add(em));
              //stafflog.setRole(em.getRole());
          }
      }
        
     try{
         if(emp.size()>=1)
         {
             return true;
         }
      }
      catch(Exception ex){
            ex.printStackTrace();
            
      }
     return false;
    }
    
    
    public void validation(){
      
        
        if(logincheck()==true)
        {
            for(Employee em: billinfo()){
                System.out.println(em.getRole());
           if(em.getEmpolyeeName().equals(Main.getLog().getUsername().getText())&&em.getPassword().equals(Main.getLog().getLogin_password().getText()))
              
          {
              //System.out.println("");
              //System.out.println("added");
             // emp.add(em);
           //   System.out.println(emp.add(em));
              stafflog.setRole(em.getRole());
          }
      }
            
             stafflog.setUsername(mf.getLog().getUsername().getText());
            
             mf.getMf().setUsername(mf.getLog().getUsername().getText());
                     
             DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
             Date date = new Date();
             stafflog.setDate(date);
             DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
             
             mf.getMf().setMain_date(formatter.format(date));
             
             dbhand.insert(stafflog);
             
             mf.getLog().setVisible(false);
             mf.getMf().setVisible(true);
             
             if(stafflog.getRole().equals("Admin"))
             {
                 mf.getMf().getBtn_trans().setEnabled(true);
             }
             else{
                 mf.getMf().getBtn_trans().setEnabled(false);
             }
             
                       
             
             
        }
        else{
            JOptionPane.showMessageDialog(null,"LOG IN FAIL!! INVALID INPUT");            
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(mf.getLog().getBtn_login() == e.getSource())
       {
           validation();
       }
    }
    
}
