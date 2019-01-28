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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author ACE
 */
@Entity
//@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
//@Table(name = "Inventory")

public class Inventory {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(name="INVENTORY_ID",unique= true, nullable=false)
    private int inventoryid;
    private String inventoryname;
    private double inventoryqty;
    private String manudate;
    private double unit;
    private String exdate;
    private String manufac;
    private int totalsold;
    
    @ManyToMany 
    private Collection<Transcation> transcation = new ArrayList();
    
    @OneToOne (cascade = CascadeType.ALL)
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public Collection<Transcation> getTranscation() {
        return transcation;
    }

    public void setTranscation(Collection<Transcation> transcation) {
        this.transcation = transcation;
    }
    
    
    
    
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy ="invent", cascade =CascadeType.ALL)
//    private Collection<InventoryTranscation>  inventoryTranscation = new ArrayList<>();
//
//    
//    public Collection<InventoryTranscation> getInventoryTransacation() {
//        return inventoryTranscation;
//    }
//
//    public void setInventoryTransaction(Collection<InventoryTranscation> inventoryTranscation) {
//        this.inventoryTranscation = inventoryTranscation;
//    }

    public int getTotalsold() {
        return totalsold;
    }

    public void setTotalsold(int totalsold) {
        this.totalsold = totalsold;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public String getManudate() {
        return manudate;
    }

    public void setManudate(String manudate) {
        this.manudate = manudate;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public String getExdate() {
        return exdate;
    }

    public void setExdate(String exdate) {
        this.exdate = exdate;
    }

    public String getManufac() {
        return manufac;
    }

    public void setManufac(String manufac) {
        this.manufac = manufac;
    }
    
      
    public int getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(int inventoryid) {
        this.inventoryid = inventoryid;
    }

    public String getInventoryname() {
        return inventoryname;
    }

    public void setInventoryname(String inventoryname) {
        this.inventoryname = inventoryname;
    }

    public double getInventorydesc() {
        return inventoryqty;
    }

    public void setInventorydesc(double inventorydesc) {
        this.inventoryqty = inventorydesc;
    }
    
    
    
}
