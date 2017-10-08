package com.vismay.ManagedBeans;

import com.vismay.SessionBeans.LaptopEJB;
import com.vismay.Entities.Laptop;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

// declared the name of the controller for the server faces.
@Named(value = "laptopController")
@ManagedBean            // managed bean annotation so framework can manage it by itself.
@RequestScoped          // session scope request.

public class LaptopController {
    
    // required objects and variable declaration
    @EJB
    private LaptopEJB laptopEJB;
    private List<Laptop> laptopList;
    private List<Laptop> lpList;
    private Laptop laptop = new Laptop();
    private String modelName = new String();
    
    // controller constructor
    public LaptopController() {
    }
    
    // this method will create the laptop entry into database and return to list page with all the details.
    public String doCreate() {
        laptopEJB.create(laptop);
        return "listOfLaptop.xhtml";
    }
    
    // this method will get the list of all the laptop according to model name.
    public String getLaptopByModel() {
        lpList = laptopEJB.getLaptopByModel(modelName);
	return "listToSearchLaptop.xhtml";
    }      
    
    // this method will get the laptop details according to id set in to the database.
    public String getLaptopById() {
        laptop = laptopEJB.getID(laptop.getId());
        return "viewLaptop.xhtml";
    }
    
    // required getters and setters
    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public List<Laptop> getLaptopList() {
        return laptopEJB.getAllLaptops();
    }

    public void setLaptopList(List<Laptop> laptopList) {
        this.laptopList = laptopList;
    }

    public List<Laptop> getLpList() {
        return lpList;
    }

    public void setLpList(List<Laptop> lpList) {
        this.lpList = lpList;
    }

    public String getLmodel() {
        return modelName;
    }

    public void setLmodel(String modelName) {
        this.modelName = modelName;
    }
    
}