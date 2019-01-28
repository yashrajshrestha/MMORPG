/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.InventoryController;
import Model.Inventory;
import Model.NewHibernateUtil;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
//import java.awt.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ACE
 */
public class InventoryForm extends javax.swing.JInternalFrame {

      private int row;
      private InventoryController inventoryController;

    public JTable getItable() {
        return itable;
    }

    public void setItable(JTable itable) {
        this.itable = itable;
    }
     
    public JButton getBtn_add() {
        return btn_add;
    }

    public void setBtn_add(JButton btn_add) {
        this.btn_add = btn_add;
    }

    public JTextField getText_id() {
        return text_id;
    }

    public void setText_id(int text_id) {
        this.text_id.setText(Integer.toString(text_id));
    }

    public JTextField getText_name() {
        return text_name;
    }

    public void setText_name(String text_name) {
        this.text_name.setText(text_name);
    }

    public JTextField getText_qty() {
        return Text_qty;
    }

    public void setText_qty(String text_qty) {
        this.Text_qty.setText(text_qty);
    }


    public JDateChooser getExpdate() {
        return expdate;
    }

    public void setExpdate(JDateChooser expdate) {
        this.expdate = expdate;
    }
    
    
    public JTextField getManucomp() {
        return manucomp;
    }

    public void setManucomp(String manucomp) {
        this.manucomp.setText(manucomp);
    }

    public JDateChooser getManudate() {
        return manudate;
    }

    public void setManudate(JDateChooser manudate) {
        this.manudate = manudate;
    }
    

    public JTextField getProductrate() {
        return productrate;
    }

    public void setProductrate(String productrate) {
        this.productrate.setText(productrate);
    }

    public JButton getBtn_idelete() {
        return btn_idelete;
    }

    public void setBtn_idelete(JButton btn_idelete) {
        this.btn_idelete = btn_idelete;
    }

    public JButton getBtn_iupdate() {
        return btn_iupdate;
    }

    public void setBtn_iupdate(JButton btn_iupdate) {
        this.btn_iupdate = btn_iupdate;
    }

    public JComboBox getSupp_box() {
        return supp_box;
    }

    public void setSupp_box(JComboBox supp_box) {
        this.supp_box = supp_box;
    }

    public JTextField getSuppilername() {
        return suppilername;
    }

    public void setSuppilername(String suppilername) {
        this.suppilername.setText(suppilername);
    }
    
    
    
    
    
    
    
    /**
     * Creates new form Item
     */
    
    
    public InventoryForm() {
        initComponents();
        
        
        inventoryController = new InventoryController();
//      Display's item_id on the jlabel
        text_id.setText(Integer.toString(inventoryController.itemid()));
        
        Iterator al = inventoryController.suppid().iterator();
        while(al.hasNext()){
            supp_box.addItem(al.next());
            
        }
        
        text_id.setVisible(false);
        
        
        
        this.btn_add.addActionListener(inventoryController);
        this.btn_iupdate.addActionListener(inventoryController);
        this.btn_idelete.addActionListener(inventoryController);
        this.supp_box.addActionListener(inventoryController);
        
//      Display's the item record
        inventoryController.displayproductinfo(itable);
        
    }

    
      
    private void rowinsert() throws ParseException{
        text_id.setText(itable.getValueAt(row,0).toString());
        text_name.setText(itable.getValueAt(row,1).toString());
        Text_qty.setText(itable.getValueAt(row,2).toString());
        productrate.setText(itable.getValueAt(row,4).toString());   
        manucomp.setText(itable.getValueAt(row,6).toString());
        suppilername.setText(itable.getValueAt(row,7).toString());
         manudate.setDate(convert(itable.getValueAt(row,3).toString()));
          expdate.setDate(convert(itable.getValueAt(row,3).toString()));     
    }
    
    
    public java.util.Date convert(String s) throws ParseException{
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
          java.util.Date date =  formatter.parse(s);
          return date;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel_itemname = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itable = new javax.swing.JTable();
        jLabel_itemqunatity = new javax.swing.JLabel();
        text_id = new javax.swing.JTextField();
        text_name = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        Text_qty = new javax.swing.JTextField();
        btn_iupdate = new javax.swing.JButton();
        btn_idelete = new javax.swing.JButton();
        label_manufacture = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productrate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        manucomp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        supp_box = new javax.swing.JComboBox();
        manudate = new com.toedter.calendar.JDateChooser();
        expdate = new com.toedter.calendar.JDateChooser();
        refresh = new javax.swing.JButton();
        suppilername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        jTextField1.setText("jTextField1");

        jLabel_itemname.setText("Med Name");

        itable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        itable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itable);

        jLabel_itemqunatity.setText("Med quantity");

        text_id.setEditable(false);

        text_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nameActionPerformed(evt);
            }
        });

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_iupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btn_iupdate.setText("update");
        btn_iupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iupdateActionPerformed(evt);
            }
        });

        btn_idelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btn_idelete.setText("delete");
        btn_idelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ideleteActionPerformed(evt);
            }
        });

        label_manufacture.setText("Manufacture Date");

        jLabel1.setText("Product Rate");

        jLabel2.setText("Expiry Date");

        jLabel3.setText("Manufacture");

        jLabel4.setText("Supplier");

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel_itemname)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(text_name, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel_itemqunatity)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Text_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_iupdate)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_idelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_manufacture)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(manudate, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addComponent(productrate)
                                .addComponent(manucomp, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                .addComponent(expdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(supp_box, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(suppilername, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(text_id, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(text_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_itemname)
                    .addComponent(text_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_itemqunatity)
                    .addComponent(Text_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_manufacture)
                    .addComponent(manudate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(productrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(expdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(manucomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(supp_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppilername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_iupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_idelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itableMouseClicked
        // TODO add your handling code here:
           row = itable.getSelectedRow();

           
          try {
              rowinsert();
          } catch (ParseException ex) {
              Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
          }
           
           
    }//GEN-LAST:event_itableMouseClicked

    private void btn_iupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iupdateActionPerformed

    }//GEN-LAST:event_btn_iupdateActionPerformed

    private void btn_ideleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ideleteActionPerformed

    }//GEN-LAST:event_btn_ideleteActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

                
    }//GEN-LAST:event_btn_addActionPerformed

    private void text_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_nameActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
      text_id.setText(Integer.toString(inventoryController.itemid()));
      text_name.setText(" ");
      Text_qty.setText(" ");
      productrate.setText(" ");
      suppilername.setText(" ");              
      expdate.setDate(null);
      manudate.setDate(null);
      
    }//GEN-LAST:event_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Text_qty;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_idelete;
    private javax.swing.JButton btn_iupdate;
    private com.toedter.calendar.JDateChooser expdate;
    private javax.swing.JTable itable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_itemname;
    private javax.swing.JLabel jLabel_itemqunatity;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_manufacture;
    private javax.swing.JTextField manucomp;
    private com.toedter.calendar.JDateChooser manudate;
    private javax.swing.JTextField productrate;
    private javax.swing.JButton refresh;
    private javax.swing.JComboBox supp_box;
    private javax.swing.JTextField suppilername;
    private javax.swing.JTextField text_id;
    private javax.swing.JTextField text_name;
    // End of variables declaration//GEN-END:variables
}
