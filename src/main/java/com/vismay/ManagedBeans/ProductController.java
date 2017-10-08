package com.vismay.ManagedBeans;

import com.vismay.SessionBeans.ProductEJB;
import com.vismay.Entities.Product;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

// declared the name of the controller for the server faces.
@Named(value = "productController")
@ManagedBean            // managed bean annotation so framework can manage it by itself.
@RequestScoped          // session scope request.

public class ProductController {
    
    // required objects and variable declaration
    @EJB
    private ProductEJB productEJB;
    private Product product = new Product();
    
    public ProductController() {
    }
    
    // this method will get the product details according to id set in to the database.
    public String getProductById() {
        product = productEJB.getID(product.getId());
        return "viewProduct.xhtml";
    }
    
    // required getters and setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
        
}