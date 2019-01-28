/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BillController;
import Controller.SellingController;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ACE
 */
public class SellingForm extends javax.swing.JInternalFrame {

    private SellingController sell;
    private ArrayList<String []> pro; 
    int row;
    private BillController bill;

    public JComboBox getItemBox() {
        return ItemBox;
    }

    public void setItemBox(JComboBox ItemBox) {
        this.ItemBox = ItemBox;
    }

    public JTextField getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(JTextField itemquantity) {
        this.itemquantity = itemquantity;
    }

    public JTextField getItemrate() {
        return itemrate;
    }

    public void setItemrate(double itemrate) {
        this.itemrate.setText(String.valueOf(itemrate));
    }

    public JButton getBtn_add() {
        return btn_add;
    }

    public void setBtn_add(JButton btn_add) {
        this.btn_add = btn_add;
    }

    public JButton getBtn_submit() {
        return btn_submit;
    }

    public void setBtn_submit(JButton btn_submit) {
        this.btn_submit = btn_submit;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }

    public JTextField getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname.setText(itemname);
    }

    public JTextField getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(JTextField grandtotal) {
        this.grandtotal = grandtotal;
    }

    public JTextField getCustomername() {
        return customername;
    }

    public void setCustomername(JTextField customername) {
        this.customername = customername;
    }

    public JTextField getTotalpayment() {
        return totalpayment;
    }

    public void setTotalpayment(JTextField totalpayment) {
        this.totalpayment = totalpayment;
    }

    public JComboBox getPaybox() {
        return paybox;
    }

    public void setPaybox(JComboBox paybox) {
        this.paybox = paybox;
    }

    public JButton getBtn_pay() {
        return Btn_pay;
    }

    public void setBtn_pay(JButton Btn_pay) {
        this.Btn_pay = Btn_pay;
    }

    public JButton getBth_cancelitem() {
        return bth_cancelitem;
    }

    public void setBth_cancelitem(JButton bth_cancelitem) {
        this.bth_cancelitem = bth_cancelitem;
    }

    public JButton getJbtn_print() {
        return jbtn_print;
    }

    public void setJbtn_print(JButton jbtn_print) {
        this.jbtn_print = jbtn_print;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Creates new form SellingForm
     */
    public SellingForm() {
        initComponents();
        sell= new SellingController();
        
        bill = new BillController();
        
        Iterator al = sell.getmedicine().iterator();
        while(al.hasNext()){
            ItemBox.addItem(al.next());
        }
        
       
        
       
        
        this.ItemBox.addActionListener(sell);
        this.btn_add.addActionListener(sell);
        this.btn_submit.addActionListener(sell);
        this.Btn_pay.addActionListener(sell);
        this.bth_cancelitem.addActionListener(sell);
        
        
        this.jbtn_print.addActionListener(bill);
        
        
    }
    
    
    
     private void rowinsert(){
         getItemBox().setSelectedItem(getjTable2().getValueAt(row, 0));
         getItemname().setText(getjTable2().getValueAt(row, 1).toString());
         getItemrate().setText(getjTable2().getValueAt(row, 2).toString());
         getItemquantity().setText(getjTable2().getValueAt(row, 3).toString());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        itemrate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ItemBox = new javax.swing.JComboBox();
        itemquantity = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        customername = new javax.swing.JTextField();
        grandtotal = new javax.swing.JTextField();
        paybox = new javax.swing.JComboBox();
        totalpayment = new javax.swing.JTextField();
        Btn_pay = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        itemname = new javax.swing.JTextField();
        jbtn_print = new javax.swing.JButton();
        bth_cancelitem = new javax.swing.JButton();

        jLabel1.setText("Item rate");

        itemrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemrateActionPerformed(evt);
            }
        });

        jLabel2.setText("Item quantity");

        jLabel3.setText("Item id");

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/order.png"))); // NOI18N
        btn_add.setText("ADD");

        btn_submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btn_submit.setText("SUBMIT");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product id", "Product name", "Rate", "quantity", "total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel4.setText("Customer-name");

        jLabel5.setText("Grand Total");

        jLabel6.setText("payment type");

        jLabel7.setText("Total payment");

        paybox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cash", "cerdit" }));

        totalpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalpaymentActionPerformed(evt);
            }
        });

        Btn_pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pay.png"))); // NOI18N
        Btn_pay.setText("Pay");
        Btn_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_payActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        jButton4.setText("Cancel order");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Item name");

        jbtn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prints.png"))); // NOI18N
        jbtn_print.setText("Print");

        bth_cancelitem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        bth_cancelitem.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_pay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtn_print)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn_add)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_submit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bth_cancelitem))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(paybox, 0, 130, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(totalpayment))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(customername)
                                                .addComponent(grandtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(itemquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel8))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(itemrate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ItemBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(14, 14, 14)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ItemBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(itemname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(itemrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(itemquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add)
                            .addComponent(btn_submit)
                            .addComponent(bth_cancelitem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(customername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(grandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(paybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(totalpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_pay)
                            .addComponent(jButton4)
                            .addComponent(jbtn_print))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemrateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemrateActionPerformed

    private void Btn_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_payActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_payActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void totalpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalpaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalpaymentActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_submitActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
         row = getjTable2().getSelectedRow();
          rowinsert();
        
    }//GEN-LAST:event_jTable2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_pay;
    private javax.swing.JComboBox ItemBox;
    private javax.swing.JButton bth_cancelitem;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_submit;
    private javax.swing.JTextField customername;
    private javax.swing.JTextField grandtotal;
    private javax.swing.JTextField itemname;
    private javax.swing.JTextField itemquantity;
    private javax.swing.JTextField itemrate;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbtn_print;
    private javax.swing.JComboBox paybox;
    private javax.swing.JTextField totalpayment;
    // End of variables declaration//GEN-END:variables
}