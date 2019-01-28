/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CompanyController;
import Controller.EmployeeController;
import Controller.SuppilerController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author ACE
 */
public class AdminForm extends javax.swing.JInternalFrame {

    private EmployeeController empcon;
    private SuppilerController suppcon;
    private CompanyController compcon; 
    private int row;

    public JComboBox getRole_Box() {
        return Role_Box;
    }

    public void setRole_Box(JComboBox Role_Box) {
        this.Role_Box = Role_Box;
    }
    
    
    
    public JTabbedPane getjTabbedPane1() {
        return jTabbedPane1;
    }

    public void setjTabbedPane1(JTabbedPane jTabbedPane1) {
        this.jTabbedPane1 = jTabbedPane1;
    }

    public JTextField getEmp_Contact() {
        return Emp_Contact;
    }

    public void setEmp_Contact(JTextField Emp_Contact) {
        this.Emp_Contact = Emp_Contact;
    }

    public JTextField getEmp_address() {
        return Emp_address;
    }

    public void setEmp_address(JTextField Emp_address) {
        this.Emp_address = Emp_address;
    }

    public JTextField getEmp_id() {
        return Emp_id;
    }

    public void setEmp_id(JTextField Emp_id) {
        this.Emp_id = Emp_id;
    }

    public JTextField getEmp_name() {
        return Emp_name;
    }

    public void setEmp_name(JTextField Emp_name) {
        this.Emp_name = Emp_name;
    }

    public JTextField getEmp_password() {
        return Emp_password;
    }

    public void setEmp_password(JTextField Emp_password) {
        this.Emp_password = Emp_password;
    }

    public JButton getBtn_emp_delete() {
        return btn_emp_delete;
    }

    public void setBtn_emp_delete(JButton btn_emp_delete) {
        this.btn_emp_delete = btn_emp_delete;
    }

    public JButton getBtn_emp_save() {
        return btn_emp_save;
    }

    public void setBtn_emp_save(JButton btn_emp_save) {
        this.btn_emp_save = btn_emp_save;
    }

    public JButton getBtn_emp_update() {
        return btn_emp_update;
    }

    public void setBtn_emp_update(JButton btn_emp_update) {
        this.btn_emp_update = btn_emp_update;
    }

    public JTable getTbl_emp() {
        return tbl_emp;
    }

    public void setTbl_emp(JTable tbl_emp) {
        this.tbl_emp = tbl_emp;
    }

    public JButton getBtn_suppde() {
        return btn_suppde;
    }

    public void setBtn_suppde(JButton btn_suppde) {
        this.btn_suppde = btn_suppde;
    }

    public JButton getBtn_suppin() {
        return btn_suppin;
    }

    public void setBtn_suppin(JButton btn_suppin) {
        this.btn_suppin = btn_suppin;
    }

    public JButton getBtn_suppup() {
        return btn_suppup;
    }

    public void setBtn_suppup(JButton btn_suppup) {
        this.btn_suppup = btn_suppup;
    }

    public JTextField getJtx_suppadd() {
        return jtx_suppadd;
    }

    public void setJtx_suppadd(JTextField jtx_suppadd) {
        this.jtx_suppadd = jtx_suppadd;
    }

    public JTextField getJtx_suppcon() {
        return jtx_suppcon;
    }

    public void setJtx_suppcon(JTextField jtx_suppcon) {
        this.jtx_suppcon = jtx_suppcon;
    }

    public JTextField getJtx_suppid() {
        return jtx_suppid;
    }

    public void setJtx_suppid(JTextField jtx_suppid) {
        this.jtx_suppid = jtx_suppid;
    }

    public JTextField getJtx_suppname() {
        return jtx_suppname;
    }

    public void setJtx_suppname(JTextField jtx_suppname) {
        this.jtx_suppname = jtx_suppname;
    }

    public JTable getJtb_supp() {
        return jtb_supp;
    }

    public void setJtb_supp(JTable jtb_supp) {
        this.jtb_supp = jtb_supp;
    }

    public JTextField getComp_id() {
        return Comp_id;
    }

    public void setComp_id(int Comp_id) {
        this.Comp_id.setText(Integer.toString(Comp_id));
    }

    public JTextField getCompaddress() {
        return compaddress;
    }

    public void setCompaddress(String compaddress) {
        this.compaddress.setText(compaddress);
    }

    public JTextField getCompcontact() {
        return compcontact;
    }

    public void setCompcontact(Long compcontact) {
        this.compcontact.setText(Long.toString(compcontact));
    }

    public JTextField getCompmail() {
        return compmail;
    }

    public void setCompmail(String compmail) {
        this.compmail.setText(compmail);
    }

    public JTextField getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname.setText(compname);
    }

    public JButton getBtn_Compudap() {
        return btn_Compudap;
    }

    public void setBtn_Compudap(JButton btn_Compudap) {
        this.btn_Compudap = btn_Compudap;
    }
    
    
    
    
    
    
    /**
     * Creates new form AdminForm
     */
    
    public AdminForm() {
        initComponents();
        Comp_id.setVisible(false);
        Emp_id.setVisible(false);
        jtx_suppid.setVisible(false);
        
        empcon = new EmployeeController();
        suppcon = new SuppilerController();
        compcon = new CompanyController();
        
        Emp_id.setText(Integer.toString(empcon.empId()));
        jtx_suppid.setText(Integer.toString(suppcon.suppid()));
        
         
        
        companyinfo();
        
        
        empcon.displayEmpInfo(getTbl_emp());
        
        suppcon.displaysupId(getJtb_supp());
        
        this.btn_emp_save.addActionListener(empcon);
        this.btn_emp_update.addActionListener(empcon);
        this.btn_emp_delete.addActionListener(empcon);
        
        this.btn_suppin.addActionListener(suppcon);
        this.btn_suppup.addActionListener(suppcon);
        this.btn_suppde.addActionListener(suppcon);
        
        this.btn_Compudap.addActionListener(compcon);
    }
    
    
    public void getSelectedRow(){
        Emp_id.setText(tbl_emp.getValueAt(row, 0).toString());
        Emp_name.setText(tbl_emp.getValueAt(row, 1).toString());
        Emp_address.setText(tbl_emp.getValueAt(row, 2).toString());
        Emp_Contact.setText(tbl_emp.getValueAt(row, 3).toString());
        Emp_password.setText(tbl_emp.getValueAt(row, 4).toString());
        
    }
    
    
    public void companyinfo(){
        Comp_id.setText(compcon.companyInfo().get(0).toString());
        compaddress.setText((String) compcon.companyInfo().get(1).toString());
        compname.setText((String) compcon.companyInfo().get(2).toString());
        compmail.setText((String) compcon.companyInfo().get(3).toString());
        compcontact.setText((String) compcon.companyInfo().get(4).toString());
                 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtb_supp = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jtx_suppid = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtx_suppname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtx_suppadd = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtx_suppcon = new javax.swing.JTextField();
        btn_suppin = new javax.swing.JButton();
        btn_suppup = new javax.swing.JButton();
        btn_suppde = new javax.swing.JButton();
        Supp_fresh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_emp = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Emp_id = new javax.swing.JTextField();
        Emp_name = new javax.swing.JTextField();
        Emp_address = new javax.swing.JTextField();
        Emp_Contact = new javax.swing.JTextField();
        Emp_password = new javax.swing.JTextField();
        btn_emp_save = new javax.swing.JButton();
        btn_emp_update = new javax.swing.JButton();
        btn_emp_delete = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        Role_Box = new javax.swing.JComboBox();
        staff_fresh = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        compname = new javax.swing.JTextField();
        compcontact = new javax.swing.JTextField();
        compmail = new javax.swing.JTextField();
        compaddress = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        btn_Compudap = new javax.swing.JButton();
        Comp_id = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Report", jPanel1);

        jtb_supp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "null", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jtb_supp);

        jLabel13.setText("SuppilerId");

        jLabel14.setText("SuppilerName");

        jLabel15.setText("SuppilerAddress");

        jtx_suppadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtx_suppaddActionPerformed(evt);
            }
        });

        jLabel16.setText("SupplierContact");

        btn_suppin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btn_suppin.setText("Insert");

        btn_suppup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btn_suppup.setText("Update");

        btn_suppde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btn_suppde.setText("Delete");

        Supp_fresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        Supp_fresh.setText("Refresh");
        Supp_fresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Supp_freshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtx_suppadd, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                    .addComponent(jtx_suppcon)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtx_suppname)
                                    .addComponent(jtx_suppid)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_suppup)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_suppde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_suppin)
                                .addGap(18, 18, 18)
                                .addComponent(Supp_fresh)))
                        .addGap(0, 57, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtx_suppid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtx_suppname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtx_suppadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jtx_suppcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_suppin)
                    .addComponent(Supp_fresh))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_suppup)
                    .addComponent(btn_suppde))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Suppiler", jPanel4);

        tbl_emp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbl_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_empMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_emp);

        jLabel8.setText("Employee-id");

        jLabel9.setText("Employee-Name");

        jLabel10.setText("Employee-Address");

        jLabel11.setText("Employee-Contact");

        jLabel12.setText("Password");

        Emp_Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Emp_ContactActionPerformed(evt);
            }
        });

        Emp_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Emp_passwordActionPerformed(evt);
            }
        });

        btn_emp_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        btn_emp_save.setText("SAVE");

        btn_emp_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btn_emp_update.setText("UPDATE");

        btn_emp_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btn_emp_delete.setText("DELETE");

        jLabel18.setText("Role");

        Role_Box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Staff" }));

        staff_fresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        staff_fresh.setText("Refresh");
        staff_fresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_freshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Emp_address, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(38, 38, 38)
                            .addComponent(Emp_id))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel18))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Emp_password, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(Emp_Contact)
                                .addComponent(Role_Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_emp_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_emp_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staff_fresh)
                            .addComponent(btn_emp_delete))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Emp_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Emp_Contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(Emp_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(Role_Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_emp_save)
                            .addComponent(staff_fresh))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_emp_delete)
                            .addComponent(btn_emp_update)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Staff", jPanel3);

        jLabel4.setText("CompanyName");

        jLabel5.setText("Company Contact");

        jLabel6.setText("Company Email");

        jLabel7.setText("Company Address");

        compaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compaddressActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jButton3.setText("Cancel");

        btn_Compudap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update.png"))); // NOI18N
        btn_Compudap.setText("Update");

        Comp_id.setEditable(false);
        Comp_id.setDisabledTextColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_Compudap)
                                .addGap(41, 41, 41)
                                .addComponent(jButton3))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(compaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Comp_id)
                                        .addComponent(compname)
                                        .addComponent(compcontact)
                                        .addComponent(compmail)))))))
                .addContainerGap(534, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Comp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(compcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(compmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(compaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Compudap)
                    .addComponent(jButton3))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Company", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compaddressActionPerformed

    private void Emp_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emp_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Emp_passwordActionPerformed

    private void Emp_ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Emp_ContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Emp_ContactActionPerformed

    private void tbl_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_empMouseClicked
        // TODO add your handling code here:
        row = tbl_emp.getSelectedRow();
        getSelectedRow();
    }//GEN-LAST:event_tbl_empMouseClicked

    private void jtx_suppaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtx_suppaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtx_suppaddActionPerformed

    private void Supp_freshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Supp_freshActionPerformed
        // TODO add your handling code here:
        jtx_suppname.setText(" ");
        jtx_suppadd.setText(" ");
        jtx_suppcon.setText(" ");
        jtx_suppid.setText(Integer.toString(suppcon.suppid()));
    }//GEN-LAST:event_Supp_freshActionPerformed

    private void staff_freshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_freshActionPerformed
        // TODO add your handling code here:
        Emp_name.setText(" ");
        Emp_address.setText(" ");
        Emp_Contact.setText(" ");
        Emp_password.setText(" ");
        Emp_id.setText(Integer.toString(empcon.empId()));
    }//GEN-LAST:event_staff_freshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Comp_id;
    private javax.swing.JTextField Emp_Contact;
    private javax.swing.JTextField Emp_address;
    private javax.swing.JTextField Emp_id;
    private javax.swing.JTextField Emp_name;
    private javax.swing.JTextField Emp_password;
    private javax.swing.JComboBox Role_Box;
    private javax.swing.JButton Supp_fresh;
    private javax.swing.JButton btn_Compudap;
    private javax.swing.JButton btn_emp_delete;
    private javax.swing.JButton btn_emp_save;
    private javax.swing.JButton btn_emp_update;
    private javax.swing.JButton btn_suppde;
    private javax.swing.JButton btn_suppin;
    private javax.swing.JButton btn_suppup;
    private javax.swing.JTextField compaddress;
    private javax.swing.JTextField compcontact;
    private javax.swing.JTextField compmail;
    private javax.swing.JTextField compname;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtb_supp;
    private javax.swing.JTextField jtx_suppadd;
    private javax.swing.JTextField jtx_suppcon;
    private javax.swing.JTextField jtx_suppid;
    private javax.swing.JTextField jtx_suppname;
    private javax.swing.JButton staff_fresh;
    private javax.swing.JTable tbl_emp;
    // End of variables declaration//GEN-END:variables
}
