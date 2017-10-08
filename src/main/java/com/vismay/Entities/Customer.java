package com.vismay.Entities;

import java.io.Serializable;
import javax.persistence.*;

//this is the entity class for the customer data.
//@Entity annotation defines this class as a entity class.
@Entity
@NamedQueries({
    @NamedQuery(name = Customer.allCustomers, query = "SELECT c FROM Customer c"), // NamedQuery to get all the data of cutomers from database.
    @NamedQuery(name = Customer.customerByName, query = "SELECT c FROM Customer c WHERE c.name = :name") // NamedQuery to get data according to the name
})
//No table name is declared so class name will be the table name
public class Customer implements Serializable {
    
    // declaration of serial version id.
    private static final long serialVersionUID = 1L;
    
    // declaration of final string variables for name queries.
    public static final String allCustomers = "Customer.allCustomers";
    public static final String customerByName = "Customer.customerByName";
    
    
    // required variables. This is the entity class so these variables defines the table coumns.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    
    // required constuctors are created.
    public Customer() {
    }

    public Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    
    // all the getters and setters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}