
package org.ymini.yschool.mayooran.entitymodel;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class StudentEntityDAO {
    
    //declaration Entity manager
    EntityManagerFactory emf;
    EntityManager em;

    
    public StudentEntityDAO() {
        //Initialization Entity manager
        this.emf = Persistence.createEntityManagerFactory("yschool-mini-mayooranPU");
        this.em = emf.createEntityManager();
    }

    public List<StudentEntity> getStudentList(int Grade) {
        Query query = em.createQuery("select s from StudentEntity s where student_grade='"+Grade+"'");
        return query.getResultList();
    }
    
     public List<StudentEntity> getStudentListAll() {
        Query query = em.createQuery("select s from StudentEntity s");
        return query.getResultList();
    }

     
     
    public List getStudentListIDs() {
        Query query = em.createQuery("select s.studentid from StudentEntity s");
        return query.getResultList();
    }
    
    
    public boolean addStudent(final StudentEntity student) {
        if (student == null) {
            return false;
        }
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        return true;
    }
    
    public List<StudentEntity> findStudent(String firstname,int grade){
        List<StudentEntity> s;       
        Query query = em.createQuery("select s from StudentEntity s where student_firstname='"+firstname+"' and student_grade='"+grade+"'");
        s=query.getResultList();      
        return s;            
            
    }

    public boolean deleteStudent(final StudentEntity student) {
        if (student == null) {
            return false;
        }
        em.getTransaction().begin();
        
        StudentEntity persistStudent = em.find(StudentEntity.class, student.getStudentid());
        if (persistStudent == null) {
            return false;
        } else {
            em.remove(persistStudent);            
            em.getTransaction().commit();
        }
        return true;
    }
    
    public boolean updateStudent(final StudentEntity student) {
        if (student == null) {
            return false;
        }
        em.getTransaction().begin();
        
        StudentEntity persistStudent = em.find(StudentEntity.class, student.getStudentid());
        if (persistStudent == null) {
            return false;
        } else {
            persistStudent.setFirstname(student.getFirstname());
            persistStudent.setLastname(student.getLastname());
            persistStudent.setAddress(student.getAddress());
            persistStudent.setGrade(student.getGrade());
            persistStudent.setGender(student.getGender());
            
            em.getTransaction().commit();
        }
        return true;
    }
}
