/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ACE
 */
@Entity
//@Table(name = "Transcation")


public class Transcation {
    @Id @GeneratedValue
    //@Column(name="TRANSACTION_ID",unique= true, nullable=false)
    private int t_id;
    private String cname;
    private double total;
    private String paytype;
    private String date;
    private String salesperson;
    
    @ManyToMany (mappedBy = "transcation")
    private Collection<Inventory> inventory = new ArrayList();
    
    public Collection<Inventory> getInventory() {
       
        return inventory;
    }

    public void setInventory(Collection<Inventory> inventory) {
        this.inventory = inventory;
    }  
    
    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(String salesperson) {
        this.salesperson = salesperson;
    }
    
    
    
}
