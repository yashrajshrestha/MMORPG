/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author ACE
 */

@Entity
public class Supplier {
    @Id @GeneratedValue
    private int suppilerid;
    private String suppilername;
    private int contact;
    private String address;
    
//    @ManyToMany (mappedBy = "transcation")
//    private Collection<Inventory> inventory = new ArrayList();

    public int getSuppilerid() {
        return suppilerid;
    }

    public void setSuppilerid(int suppilerid) {
        this.suppilerid = suppilerid;
    }

    public String getSuppilername() {
        return suppilername;
    }

    public void setSuppilername(String suppilername) {
        this.suppilername = suppilername;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
