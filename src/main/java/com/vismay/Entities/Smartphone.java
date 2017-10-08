package com.vismay.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//this is the entity class for the smart phones data.
//@Entity annotation defines this class as a entity class.
@Entity
@NamedQueries({
    @NamedQuery(name = Smartphone.allSmartPhones, query = "SELECT s FROM Smartphone s"), // NamedQuery to get all the data of smart phones from database.
    @NamedQuery(name = Smartphone.smartPhonesByModel, query = "SELECT s FROM Smartphone s WHERE s.model = :model") // NamedQuery to get data according to the model
})
//this entity class extends the product entity to store common data of product.
public class Smartphone extends Product {
    
    // declaration of final string variables for name queries.
    public static final String allSmartPhones = "Smartphone.allSmartPhones";
    public static final String smartPhonesByModel = "Smartphone.smartPhonesByModel";
    
    // required variables. This is the entity class so these variables defines the table coumns.
    @Column(nullable = false)
    private String cellularConnectivity;
    private String location;    
    private String simCard;    
    
    // required constuctors are created.
    public Smartphone() {
    }

    public Smartphone(String cellularConnectivity, String location, String simCard, Integer numberOfSmartphone, String brand, String model, String sizeOfDisplay, String weight, String os, String camera, String wifi, Double price, String type, Integer number) {
        super(brand, model, sizeOfDisplay, weight, os, camera, wifi, price, type, number);
        this.cellularConnectivity = cellularConnectivity;
        this.location = location;
        this.simCard = simCard;
    }
    
    // all the getters and setters.
    public String getCellularConnectivity() {
        return cellularConnectivity;
    }

    public void setCellularConnectivity(String cellularConnectivity) {
        this.cellularConnectivity = cellularConnectivity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSimCard() {
        return simCard;
    }

    public void setSimCard(String simCard) {
        this.simCard = simCard;
    }
 
}