package com.vismay.SessionBeans;

import com.vismay.Entities.Product;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// declaration of this session bean as stateless and local bean
@Stateless
@LocalBean

public class ProductEJB {
    
    // providing name of the persistence unit for session beans
    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;   // EntityManger object to handle all database operations.
                              // I havent created any entity manager factory object in order to avoid errors related to eclipse link.
    
    // this method will get the id column value of the perticular product for further operations.
    public Product getID(Long id) {
        return this.em.find(Product.class, id);
    }
    
    // this method will reduce the quantity according to order created.
    public void updateQuantity(Product p, int numberToReduce)  {
        int temp;
	temp = p.getNumber();
	temp = temp - numberToReduce;
	p.setNumber(temp);
	em.merge(p);
    }
       
}