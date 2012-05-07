
package org.ymini.yschool.mayooran.entitymodel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ResultEntityDAO {
    //declaration Entity manager
    EntityManagerFactory emf;
    EntityManager em;

    public ResultEntityDAO() {
        //Initialization Entity manager
        this.emf = Persistence.createEntityManagerFactory("yschool-mini-mayooranPU");
        this.em = emf.createEntityManager();
    }
    public boolean addResult(final ResultEntity result) {
        if (result == null) {
            return false;
        }
        em.getTransaction().begin();
        em.persist(result);
        em.getTransaction().commit();
        return true;
    }
    
}
