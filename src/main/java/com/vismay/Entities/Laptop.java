package com.vismay.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//this is the entity class for the laptop data.
//@Entity annotation defines this class as a entity class.
@Entity
@NamedQueries({
    @NamedQuery(name = Laptop.allLaptops, query = "SELECT l FROM Laptop l"), // NamedQuery to get all the data of laptops from database.
    @NamedQuery(name = Laptop.laptopsByModel, query = "SELECT l FROM Laptop l WHERE l.model = :model") // NamedQuery to get data according to the model
})
//this entity class extends the product entity to store common data of product.
public class Laptop extends Product {
    
    // declaration of final string variables for name queries.
    public static final String allLaptops = "Laptop.allLaptops";
    public static final String laptopsByModel = "Laptop.laptopsByModel";
    
    // required variables. This is the entity class so these variables defines the table coumns.
    @Column(nullable = false)
    private String networkInterface;
    private String hardDrive;    
    private String opticalDrive;    
    
    // required constuctors are created.
    public Laptop() {
    }

    public Laptop(String networkInterface, String hardDrive, String opticalDrive, Integer numberOfLaptop, String brand, String model, String sizeOfDisplay, String weight, String os, String camera, String wifi, Double price, String type, Integer number) {
        super(brand, model, sizeOfDisplay, weight, os, camera, wifi, price, type, number);
        this.networkInterface = networkInterface;
        this.hardDrive = hardDrive;
        this.opticalDrive = opticalDrive;
    }
    
    // all the getters and setters.
    public String getNetworkInterface() {
        return networkInterface;
    }

    public void setNetworkInterface(String networkInterface) {
        this.networkInterface = networkInterface;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getOpticalDrive() {
        return opticalDrive;
    }

    public void setOpticalDrive(String opticalDrive) {
        this.opticalDrive = opticalDrive;
    }

}