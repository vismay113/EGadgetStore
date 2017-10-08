package com.vismay.SessionBeans;

import com.vismay.Entities.Laptop;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

// declaration of this session bean as stateless and local bean
@Stateless
@LocalBean

public class LaptopEJB {
    
    // providing name of the persistence unit for session beans
    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;   // EntityManger object to handle all database operations.
                              // I havent created any entity manager factory object in order to avoid errors related to eclipse link.
    
    // this method will get the data of all laptops through typed query feature from database and the return the list of phones.
    public List<Laptop> getAllLaptops() {
        TypedQuery<Laptop> query = em.createNamedQuery(Laptop.allLaptops, Laptop.class);
        return query.getResultList();
    }    
    
    // this method will get the data of all laptops according to model name through typed query feature from database.
    public List<Laptop> getLaptopByModel(String model) {
        TypedQuery<Laptop> query = em.createNamedQuery(Laptop.laptopsByModel, Laptop.class);
	query.setParameter("model", model);
        return query.getResultList();
    }    
    
    // this method will get the id column value of the perticular laptop for further process.
    public Laptop getID(Long id) {
        return this.em.find(Laptop.class, id);
    }    
    
    // this method will store the data of new laptop with entity manager.
    public void create(Laptop laptop) {
        em.persist(laptop);
    }
    
    // this method will update the data of laptop with entity manager through the id value as id is a primary key.
    public void update(Laptop laptop) {
        em.merge(laptop);
    }
    
    // this method will delete the data of laptop with entity manager through the id value as id is a primary key.
    public void delete(Long id) {
        em.remove(em.find(Laptop.class, id));
    }

}