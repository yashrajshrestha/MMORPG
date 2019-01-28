/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author ACE
 */
public class Main {
    
    private static Login log;
    private static MainForm mf;
    

    public MainForm getMf() {
        return mf;
    }

    public void setMf(MainForm mf) {
        Main.mf = mf;
    }

    public static Login getLog() {
        return log;
    }

    public static void setLog(Login log) {
        Main.log = log;
    }

  
    
    
    
    
    
    
    public static void main(String[] args) {
        
       log = new Login();
       log.setVisible(true);
       //log.setSize(400, 500);
       log.setResizable(false);
       log.setVisible(true);
       
       mf = new MainForm();
     // mf.setVisible(true);
      //  im = new InventoryForm();
    }
    
}
