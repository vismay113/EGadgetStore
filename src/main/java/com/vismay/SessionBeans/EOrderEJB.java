package com.vismay.SessionBeans;

import com.vismay.Entities.EOrder;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

// declaration of this session bean as stateless and local bean
@Stateless
@LocalBean

public class EOrderEJB {
    
    // providing name of the persistence unit for session beans
    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;   // EntityManger object to handle all database operations.
                              // I havent created any entity manager factory object in order to avoid errors related to eclipse link.
    
    // this method will get the data of all orders through typed query feature from database and the return the list of orders.
    public List<EOrder> getAllOrders() {
        TypedQuery<EOrder> query = em.createNamedQuery(EOrder.allOrders, EOrder.class);
        return query.getResultList();
    }    
    
    // this method will get the order id to set in query to find the specific customer order.
    public List<EOrder> getOrderID(Long id) {
        TypedQuery<EOrder> query = em.createNamedQuery(EOrder.getOrderId, EOrder.class);
	query.setParameter("id", id);
        return query.getResultList();
    }
    
    // this method will get the data of the customer specific order .
    public List<EOrder> getSpecificCustomerOrder(Long id) {
        TypedQuery<EOrder> query = em.createNamedQuery(EOrder.getSpecificOrder, EOrder.class);
	query.setParameter("id", id);
        return query.getResultList();
    }    
    
    // this method will get the id column value of the perticular order for further process.
    public EOrder getID(Long id) {
        return this.em.find(EOrder.class, id);
    }    
    
    // this method will store the data of new orders with entity manager.
    public void create(EOrder corder) {
        em.persist(corder);
    }
    
    // this method will update the data of order with entity manager through the id value as id is a primary key.
    public void update(EOrder corder) {
        em.merge(corder);
    }
    
    // this method will delete the data of order with entity manager through the id value as id is a primary key.
    public void delete(Long id) {
        em.remove(em.find(EOrder.class, id));
    }
    
}