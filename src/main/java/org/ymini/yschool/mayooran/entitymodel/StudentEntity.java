package org.ymini.yschool.mayooran.entitymodel;



import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;


@Entity
public class StudentEntity implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private int studentid;
    
    @OneToMany
    private Collection<ResultEntity> subjects;
    
    @Column(name = "student_firstname")
    private String firstname;
    
    @Column(name = "student_lastname")
    private String lastname;
    
    @Column(name = "student_address")
    private String address;
    
    @Column(name = "student_grade")
    private int grade;
    
    @Column(name = "student_gender")
    private String gender;
    
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
             message="{invalid.email}")
    @Column(name = "student_email")
    private String email;
    
    
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
             message="{invalid.phonenumber}")
    @Column(name = "student_mobilePhone")
    private String mobilePhone;
    
    
    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
             message="{invalid.phonenumber}")
    @Column(name = "student_homePhone")
    private String homePhone;
    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Past
    @Column(name = "student_birthday")
    private Date birthday;

    
    public StudentEntity() {
        
    }   

    public StudentEntity(String firstname, String lastname, String address, int grade, String gender, String email, String mobilePhone, String homePhone, Date birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.grade = grade;
        this.gender = gender;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.birthday = birthday;
    }

    
    
    
    
    // Getters and Setters
    
    public Collection<ResultEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(Collection<ResultEntity> subjects) {
        this.subjects = subjects;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    

    
  
}
