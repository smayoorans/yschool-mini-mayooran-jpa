
package org.ymini.yschool.mayooran.entitymodel;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class SubjectEntityDAO {
    
    //declaration Entity manager
    EntityManagerFactory emf;
    EntityManager em;

    public SubjectEntityDAO() {
        //Initialization Entity manager
        this.emf = Persistence.createEntityManagerFactory("yschool-mini-mayooranPU");
        this.em = emf.createEntityManager();
    }
    
    public List<SubjectEntity> getSubjectList() {
        Query query = em.createQuery("select s from SubjectEntity s");
        return query.getResultList();
    }

    public boolean addSubject(final SubjectEntity subject) {
        if (subject == null) {
            return false;
        }
        em.getTransaction().begin();
        em.persist(subject);
        em.getTransaction().commit();
        return true;
    }
    
    public List<SubjectEntity> findSubject(String subjectname){
        List<SubjectEntity> s;       
        Query query = em.createQuery("select s from SubjectEntity s where subject_name='"+subjectname+"'");
        s=query.getResultList();      
        return s;            
            
    }

    public boolean deleteSubject(final SubjectEntity subject) {
        if (subject == null) {
            return false;
        }
        em.getTransaction().begin();
        
        SubjectEntity persistSubject = em.find(SubjectEntity.class, subject.getSubjectid());
        if (persistSubject == null) {
            return false;
        } else {
            em.remove(persistSubject);            
            em.getTransaction().commit();
        }
        return true;
    }
    
    public boolean updateSubject(final SubjectEntity subject) {
        if (subject == null) {
            return false;
        }
        em.getTransaction().begin();
        
        SubjectEntity persistSubject = em.find(SubjectEntity.class, subject.getSubjectid());
        if (persistSubject == null) {
            return false;
        } else {
            persistSubject.setSubjectname(subject.getSubjectname());
            persistSubject.setSubjectteacher(subject.getSubjectteacher());          
            
            em.getTransaction().commit();
        }
        return true;
    }
    
    public List getSubjectListIDs() {
        Query query = em.createQuery("select s.subjectid from SubjectEntity s");
        return query.getResultList();
    }
    
    
}
