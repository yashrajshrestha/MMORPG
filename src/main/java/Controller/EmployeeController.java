/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DbHandler;
import Model.Employee;
import Model.Inventory;
import View.AdminForm;
import View.Main;
import View.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ACE
 */
public class EmployeeController implements ActionListener {

    private Employee emp;
    private DbHandler dbhand;
    private Main mf;
    
    public EmployeeController() {
        emp = new Employee();
       // adform = new AdminForm();
        dbhand = new DbHandler();
        mf = new Main();
    }
    
    public int empId(){
        List a = dbhand.select("select max(employeeId) from Employee");
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
    
    public void displayEmpInfo(JTable e){
         List<Employee> product = dbhand.select("from Employee");
    
        
         Vector<String> tableHeaders = new Vector<String>();
    
         tableHeaders.add("Employee ID"); 
         tableHeaders.add("Employee Name");
         tableHeaders.add("Employee Address");
         tableHeaders.add("Employee Contact");
         tableHeaders.add("password");
     

         
         Vector tableData = new Vector();
  
         for(Employee o: product)
         {
             //Inventory invent = (Inventory) o;
             Vector<Object> oneRow = new Vector<Object>();
        oneRow.add(o.getEmployeeId());
        oneRow.add(o.getEmpolyeeName());
        oneRow.add(o.getEmpolyeeAddress());
        oneRow.add(o.getEmpolyeeContact());
        oneRow.add(o.getPassword());
      
        tableData.add(oneRow);
      //    Object[] a = {o.getEmployeeId(),o.getEmpolyeeName(),o.getEmpolyeeAddress(),o.getEmpolyeeContact(),o.getPassword()};
         e.setModel(new DefaultTableModel(tableData, tableHeaders));
          
        }
       //e.setModel(new DefaultTableModel(tableData, tableHeaders));
       
    }
    
    public void insertEmp(){
         try{
                emp.setEmployeeId(Integer.parseInt(mf.getMf().getAdminform().getEmp_id().getText()));
                emp.setEmpolyeeName(mf.getMf().getAdminform().getEmp_name().getText());
                emp.setEmpolyeeAddress(mf.getMf().getAdminform().getEmp_address().getText());
                emp.setEmpolyeeContact(mf.getMf().getAdminform().getEmp_Contact().getText());
                emp.setPassword(mf.getMf().getAdminform().getEmp_password().getText());
                emp.setRole(mf.getMf().getAdminform().getRole_Box().getSelectedItem().toString());
                dbhand.insert(emp);
                
                displayEmpInfo(mf.getMf().getAdminform().getTbl_emp());
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        } 
        
    }
    
    public void updateEmp(){
         try{
                emp.setEmployeeId(Integer.parseInt(mf.getMf().getAdminform().getEmp_id().getText()));
                emp.setEmpolyeeName(mf.getMf().getAdminform().getEmp_name().getText());
                emp.setEmpolyeeAddress(mf.getMf().getAdminform().getEmp_address().getText());
                emp.setEmpolyeeContact(mf.getMf().getAdminform().getEmp_Contact().getText());
                emp.setPassword(mf.getMf().getAdminform().getEmp_password().getText());
                emp.setRole(mf.getMf().getAdminform().getRole_Box().getSelectedItem().toString());
                dbhand.update(emp);
                
                displayEmpInfo(mf.getMf().getAdminform().getTbl_emp());
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        } 
    }
    
    public void deleteEmp(){
         try{
                emp.setEmployeeId(Integer.parseInt(mf.getMf().getAdminform().getEmp_id().getText()));
                emp.setEmpolyeeName(mf.getMf().getAdminform().getEmp_name().getText());
                emp.setEmpolyeeAddress(mf.getMf().getAdminform().getEmp_address().getText());
                emp.setEmpolyeeContact(mf.getMf().getAdminform().getEmp_Contact().getText());
                emp.setPassword(mf.getMf().getAdminform().getEmp_password().getText());
                emp.setRole(mf.getMf().getAdminform().getRole_Box().getSelectedItem().toString());  
                dbhand.delete(emp);
                
                displayEmpInfo(mf.getMf().getAdminform().getTbl_emp());
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        } 
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(mf.getMf().getAdminform().getBtn_emp_save() == e.getSource()){
            insertEmp();
       }   
       else if(mf.getMf().getAdminform().getBtn_emp_update()== e.getSource()){
           updateEmp();
       }
       
       else if(mf.getMf().getAdminform().getBtn_emp_delete()== e.getSource()){
           deleteEmp();
       }
       else{
           System.out.println("Not a command");
       }
    }
    
    
    
}
