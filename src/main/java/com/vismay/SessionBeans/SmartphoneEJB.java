package com.vismay.SessionBeans;

import com.vismay.Entities.Smartphone;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

// declaration of this session bean as stateless and local bean
@Stateless
@LocalBean
public class SmartphoneEJB {
    
    // providing name of the persistence unit for session beans
    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;   // EntityManger object to handle all database operations.
                              // I havent created any entity manager factory object in order to avoid errors related to eclipse link.
    
    // this method will get the data of all smart phones through typed query feature from database and the return the list of phones.
    public List<Smartphone> getAllSmartPhones() {
        TypedQuery<Smartphone> query = em.createNamedQuery(Smartphone.allSmartPhones, Smartphone.class);
        return query.getResultList();
    }    
    
    // this method will get the data of all smart phones according to model name through typed query feature from database.
    public List<Smartphone> getSmartPhonesByModel(String model) {
        TypedQuery<Smartphone> query = em.createNamedQuery(Smartphone.smartPhonesByModel, Smartphone.class);
	query.setParameter("model", model);
        return query.getResultList();
    }    
    
    // this method will get the id column value of the perticular smart phone for further process.
    public Smartphone getID(Long id) {
        return this.em.find(Smartphone.class, id);
    }    
    
    // this method will store the data of new smart phones with entity manager.
    public void create(Smartphone smartphone) {
        em.persist(smartphone);
    }
    
    // this method will update the data of smart phones with entity manager through the id value as id is a primary key.
    public void update(Smartphone smartphone) {
        em.merge(smartphone);
    }
    
    // this method will delete the data of smart phones with entity manager through the id value as id is a primary key.
    public void delete(Long id) {
        em.remove(em.find(Smartphone.class, id));
    }

}