package com.vismay.ManagedBeans;

import com.vismay.Entities.Customer;
import com.vismay.Entities.EOrder;
import com.vismay.Entities.Product;
import com.vismay.SessionBeans.CustomerEJB;
import com.vismay.SessionBeans.EOrderEJB;
import com.vismay.SessionBeans.LaptopEJB;
import com.vismay.SessionBeans.ProductEJB;
import com.vismay.SessionBeans.SmartphoneEJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

// declared the name of the controller for the server faces.
@Named(value = "orderController")
@ManagedBean                // managed bean annotation so framework can manage it by itself.
@RequestScoped              // session scope request.

public class EOrderController {
    
    // required objects and variable declaration
    @EJB private EOrderEJB orderEJB;
    @EJB private CustomerEJB customerEJB;
    @EJB private LaptopEJB laptopEJB;
    @EJB private SmartphoneEJB smartphoneEJB;
    @EJB private ProductEJB productEJB;
    
    private List<EOrder> orderList;
    private List<EOrder> orders;
    private EOrder order = new EOrder();
    private Long cus_id;
    
    private List<Customer> customerList = new ArrayList<Customer>();   
    private List<Product> productList = new ArrayList<Product>();
    
    private Long customerId;
    private Long productId;    
    
    // controller constructor
    public EOrderController() {
    }
    
    // method to display appropriate message to user screen.
    private void display(String message, FacesMessage.Severity severity) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, message, ""));
    }
    
    // method to display appropriate message to user screen.
    private void display(String message) {
        this.display(message, FacesMessage.SEVERITY_INFO);
    }    
    
    // this method will create the order entry into database and return to list page with all the details.
    // this method will also update the quantity into the database.
    public String doCreate() {
        Customer orderCustomer = this.getCustomerFromId(this.customerId);
        Product orderProduct = this.getProductFromId(this.productId);

        if (this.order.getQuantity() > orderProduct.getNumber()) {
            display("Order cannot be created due to low quantity.");        
        } else {
            order.setProduct(orderProduct);
            order.setCustomer(orderCustomer);
            
            orderEJB.update(order);
            
	    int numberToReduce;
	    numberToReduce = this.order.getQuantity();
            productEJB.updateQuantity(orderProduct, numberToReduce); 
            
            this.orderList = orderEJB.getAllOrders();
            return "listOfOrders.xhtml";
        }
        return "newOrder.xhtml";
    }    
    
    // this method will get the order detail by the customer id.
    public String getOrderByCustomerId() {
        orders = orderEJB.getOrderID(cus_id);
	return "listToSearchOrders.xhtml";
    }
    
    // this method will delete the order from the order id.
    // this method will also update the quantity into the database.
    public String deleteOrder(EOrder order) {
        orderEJB.delete(order.getId());
	Product orderProduct = order.getProduct();

	int numberToReduce;
	numberToReduce = order.getQuantity();
        productEJB.updateQuantity(orderProduct, -numberToReduce);

        this.orderList = orderEJB.getAllOrders();        
        return "listOfOrders.xhtml";
    }
    
    // this method will get the order details according to id set in to the database.
    public String getOrderById() {
        order = orderEJB.getID(order.getId());
        return "viewOrder.xhtml";
    }    
    
    //this method will get the customer details for the perticular order.
    private Customer getCustomerFromId(Long customerId) {
        return customerEJB.getID(customerId);
    }
    
    // this method will get the product details for the perticular order.
    private Product getProductFromId(Long productId) {
        return productEJB.getID(productId);
    }    
    
    // required getters and setters.
    public List<EOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<EOrder> orders) {
        this.orders = orders;
    }

    public EOrder getOrder() {
        return order;
    }

    public void setOrder(EOrder order) {
        this.order = order;
    }

    public Long getCus_id() {
        return cus_id;
    }

    public void setCus_id(Long cus_id) {
        this.cus_id = cus_id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    // this method will update the customer list according to order operations.
    public List<Customer> getCustomerList() {
        this.customerList.clear();
        this.customerList.addAll(this.customerEJB.getAllCustomers());
        return this.customerList;
    }
    
    // this method will update the product list according to order operations.
    public List<Product> getProductList() {
        this.productList.clear();
        this.productList.addAll(this.laptopEJB.getAllLaptops());
        this.productList.addAll(this.smartphoneEJB.getAllSmartPhones());
        return this.productList;
    }    

}