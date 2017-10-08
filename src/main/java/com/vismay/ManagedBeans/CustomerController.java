package com.vismay.ManagedBeans;

import com.vismay.SessionBeans.EOrderEJB;
import com.vismay.SessionBeans.CustomerEJB;
import com.vismay.Entities.EOrder;
import com.vismay.Entities.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

// declared the name of the controller for the server faces.
@Named(value = "customerController")
@ManagedBean            // managed bean annotation so framework can manage it by itself.
@RequestScoped          // session scope request.

public class CustomerController {
    
    // required objects and variable declaration
    @EJB private CustomerEJB customerEJB;
    @EJB private EOrderEJB orderEJB;
    private List<Customer> customerList;
    private List<Customer> cusList;
    private Customer customer = new Customer();
    private String name = new String();
    private List<EOrder> orderList = new ArrayList<EOrder>();
    
    // controller constructor
    public CustomerController() {
    }
    
    // this method will create the new customer entry into database and return to list page with all the details.
    public String doCreate() {
        customerEJB.create(customer);
        return "listOfCustomer.xhtml";
    }
    
    // this method will get the list of all the customers according to name.
    public String getCustomerByName() {
        cusList = customerEJB.getCustomerByName(name);
	return "listToSearchCustomer.xhtml";
    }      
    
    // this method will get the customer details according to id set in to the database.
    public String getCusById() {
        orderList = orderEJB.getSpecificCustomerOrder(customer.getId());        
        customer = customerEJB.getID(customer.getId());
        return "viewCustomer.xhtml";
    }    
    
    // required getters and setters
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {
        return customerEJB.getAllCustomers();
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
    
    public List<Customer> getCusList() {
        return cusList;
    }

    public void setCusList(List<Customer> cusList) {
        this.cusList = cusList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<EOrder> orderList) {
        this.orderList = orderList;
    }
}