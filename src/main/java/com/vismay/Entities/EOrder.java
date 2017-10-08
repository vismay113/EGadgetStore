package com.vismay.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//this is the entity class for the customer order data.
//@Entity annotation defines this class as a entity class.
@Entity
@NamedQueries({
    @NamedQuery(name = EOrder.allOrders, query = "SELECT o FROM EOrder o"), // NamedQuery to get all the data of cutomer orders from database.
    @NamedQuery(name = EOrder.getOrderId, query = "SELECT o FROM EOrder o WHERE o.id = :id"), // NamedQuery to get order id to mapp other data through id
    @NamedQuery(name = EOrder.getSpecificOrder, query = "SELECT o FROM EOrder o WHERE o.customer.id = :id") // NamedQuery to get specific customer order data
})

public class EOrder implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    // declaration of final string variables for name queries.
    public static final String allOrders = "EOrder.allOrders";
    public static final String getOrderId = "EOrder.getOrderId"; 
    public static final String getSpecificOrder = "EOrder.getSpecificOrder";
    
    // required variables. This is the entity class so these variables defines the table coumns.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    protected Integer quantity;
    @Column(nullable = false)
    protected Double unitPrice;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date timeCreated = new Date();    

    @ManyToOne // many-to-one relationship to map order table with customer table.
    @JoinColumn(name="CUSTOMER_ID", referencedColumnName = "ID")
    private Customer customer;
    
    @ManyToOne // many-to-one relationship to map order table with product table.
    @JoinColumn(name="PRODUCT_ID", referencedColumnName = "ID")
    private Product product;    
    
    // required constuctors are created.
    public EOrder() {
    }
    
    // all the getters and setters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.unitPrice = this.product.getPrice();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }    
    
    public Double getTotalPrice() {
        return this.unitPrice * this.quantity;
    }    

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }
    
}