package com.vismay.Entities;

import java.io.Serializable;
import javax.persistence.*;

//this is the entity class for the Product data. this is the super class for smartphone and laptop entity classes.
//@Entity annotation defines this class as a entity class.
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//No table name is declared so class name will be the table name
public class Product implements Serializable {
    
    // declaration of serial version id.
    private static final long serialVersionUID = 1L;
    
    // required variables. This is the entity class so these variables defines the table coumns.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;    
    @Column(nullable = false)
    private String sizeOfDisplay;
    private String weight;   
    private String os;    
    private String camera;
    private String wifi;   
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private Integer number;    
    
    // required constuctors are created.
    public Product() {
    }

    public Product(String brand, String model, String sizeOfDisplay, String weight, String os, String camera, String wifi, Double price, String type, Integer number) {
        this.brand = brand;
        this.model = model;
        this.sizeOfDisplay = sizeOfDisplay;
        this.weight = weight;
        this.os = os;
        this.camera = camera;
        this.wifi = wifi;
        this.price = price;
        this.type = type;
        this.number = number;
    }
    
    // all the getters and setters.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSizeOfDisplay() {
        return sizeOfDisplay;
    }

    public void setSizeOfDisplay(String sizeOfDisplay) {
        this.sizeOfDisplay = sizeOfDisplay;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}