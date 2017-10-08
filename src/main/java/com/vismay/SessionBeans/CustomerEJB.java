package com.vismay.SessionBeans;

import com.vismay.Entities.Customer;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

// declaration of this session bean as stateless and local bean
@Stateless
@LocalBean
public class CustomerEJB {
    
    // providing name of the persistence unit for session beans
    @PersistenceContext(unitName = "MyPU")
    private EntityManager em; // EntityManger object to handle all database operations.
                              // I havent created any entity manager factory object in order to avoid errors related to eclipse link.
    
    // this method will get the data of all customers through typed query feature from database and the return the list of customers.
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery(Customer.allCustomers, Customer.class);
        return query.getResultList();
    }    
    
    // this method will get the data of all customers according to name through typed query feature from database.
    public List<Customer> getCustomerByName(String name) {
        TypedQuery<Customer> query = em.createNamedQuery(Customer.customerByName, Customer.class);
	query.setParameter("name", name);
        return query.getResultList();
    }    
    
    // this method will get the id column value of the perticular customer for further process.
    public Customer getID(Long id) {
        return this.em.find(Customer.class, id);
    }    
    
    // this method will store the data of new customer with entity manager.
    public void create(Customer customer) {
        em.persist(customer);
    }
    
    // this method will update the data of customer with entity manager through the id value as id is a primary key.
    public void update(Customer customer) {
        em.merge(customer);
    }
    
    // this method will delete the data of customer with entity manager through the id value as id is a primary key.
    public void delete(Long id) {
        em.remove(em.find(Customer.class, id));
    }
    
}