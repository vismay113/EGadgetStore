package com.vismay.ManagedBeans;

import com.vismay.SessionBeans.SmartphoneEJB;
import com.vismay.Entities.Smartphone;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

// declared the name of the controller for the server faces.
@Named(value = "smartphoneController")
@ManagedBean            // managed bean annotation so framework can manage it by itself.
@RequestScoped          // session scope request.

public class SmartphoneController {
    
    // required objects and variable declaration
    @EJB
    private SmartphoneEJB smartphoneEJB;
    private List<Smartphone> phoneList;
    private List<Smartphone> spList;
    private Smartphone smartphone = new Smartphone();
    private String modelName = new String();
    
    // controller constructor
    public SmartphoneController() {
    }
    
    // this method will create the smart phone entry into database and return to list page with all the details.
    public String doCreate() {
        smartphoneEJB.create(smartphone);
        return "listOfSmartPhone.xhtml";
    }
    
    // this method will get the list of all the smart phones according to model name.
    public String getPhoneByModel() {
        spList = smartphoneEJB.getSmartPhonesByModel(modelName);
	return "listToSearchSmartPhone.xhtml";
    }      
    
    // this method will get the phone details according to id set in to the database.
    public String getPhoneById() {
        smartphone = smartphoneEJB.getID(smartphone.getId());
        return "viewSmartphone.xhtml";
    }
    
    // required getters and setters
    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }
    
    public List<Smartphone> getSmartphoneList() {
        return smartphoneEJB.getAllSmartPhones();
    }

    public void setSmartphoneList(List<Smartphone> phoneList) {
        this.phoneList = phoneList;
    }

    public List<Smartphone> getSpList() {
        return spList;
    }

    public void setSpList(List<Smartphone> spList) {
        this.spList = spList;
    }

    public String getSmodel() {
        return modelName;
    }

    public void setSmodel(String modelName) {
        this.modelName = modelName;
    }
    
}