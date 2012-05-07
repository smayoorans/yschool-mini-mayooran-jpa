
package org.ymini.yschool.mayooran.entitymodel;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class ResultEntity implements Serializable {
    
    @Id    
    private int studentid;
    
    @Id    
    private int subjectid;    
   
    @Column(name = "student_marks")
    private int studentmarks;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="STUDENTID",referencedColumnName="STUDENTID")
    private StudentEntity student;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="SUBJECTID",referencedColumnName="SUBJECTID")
    private SubjectEntity subject;

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getStudentmarks() {
        return studentmarks;
    }

    public void setStudentmarks(int studentmarks) {
        this.studentmarks = studentmarks;
    }

    public SubjectEntity getSubject() {
        return subject;
    }

    public void setSubject(SubjectEntity subject) {
        this.subject = subject;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }
    
    
}
