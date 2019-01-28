/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ACE
 */

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String empolyeeName;
    private String empolyeeAddress;
    private String empolyeeContact;
    private String password;
    private String role;
    

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpolyeeName() {
        return empolyeeName;
    }

    public void setEmpolyeeName(String empolyeeName) {
        this.empolyeeName = empolyeeName;
    }

    public String getEmpolyeeAddress() {
        return empolyeeAddress;
    }

    public void setEmpolyeeAddress(String empolyeeAddress) {
        this.empolyeeAddress = empolyeeAddress;
    }

    public String getEmpolyeeContact() {
        return empolyeeContact;
    }

    public void setEmpolyeeContact(String empolyeeContact) {
        this.empolyeeContact = empolyeeContact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
    
    
}
