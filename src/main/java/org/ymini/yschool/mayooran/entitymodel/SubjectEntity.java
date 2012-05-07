
package org.ymini.yschool.mayooran.entitymodel;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class SubjectEntity implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private int subjectid;    
    
    @OneToMany
    private Collection<ResultEntity> students;
    
    @Column(name = "subject_name")
    private String subjectname;

    @Column(name = "subject_teacher")
    private String subjectteacher;

    
    
    
    
    
    
    // Getters and Setters
    public Collection<ResultEntity> getStudents() {
        return students;
    }

    public void setStudents(Collection<ResultEntity> students) {
        this.students = students;
    }
    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectteacher() {
        return subjectteacher;
    }

    public void setSubjectteacher(String subjectteacher) {
        this.subjectteacher = subjectteacher;
    }
    
    
    
    
    
    
    
    
    
    

   
    
}
