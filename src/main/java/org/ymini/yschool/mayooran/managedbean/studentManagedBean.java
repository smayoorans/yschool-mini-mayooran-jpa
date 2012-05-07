package org.ymini.yschool.mayooran.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.ymini.yschool.mayooran.entitymodel.StudentEntity;
import org.ymini.yschool.mayooran.entitymodel.StudentEntityDAO;


@ManagedBean
@SessionScoped
public final class studentManagedBean implements Serializable{
    
    private static final Logger log = Logger.getLogger(studentManagedBean.class);
    
    private StudentEntity insertedStudent;
    private StudentEntity selectedStudent;
    private StudentEntity searchedStudent;
   
        
    private String firstname;
    private int grade;   
    StudentEntityDAO studentDAO;
    
 
    public studentManagedBean() {
        
        this.insertedStudent = new StudentEntity();
        this.selectedStudent=new StudentEntity();
        this.searchedStudent=new StudentEntity();
        
        
        this.firstname=searchedStudent.getFirstname();        
        this.grade=searchedStudent.getGrade();  
        
        this.studentDAO = new StudentEntityDAO();     
       
       log.info("Initiated StudentManagedBean");
    }

    public List<StudentEntity> getStudentList() {
        return this.studentDAO.getStudentList(grade);
        
    }    
   //View the Student List in a table
    public List<StudentEntity> getSearchStudentX(){        
        List<StudentEntity> sStudent;
        if(grade==0){
            sStudent=this.studentDAO.getStudentListAll();
        }
        else{
            sStudent=this.studentDAO.getStudentList(grade);
            log.info("Searched Student");
        }
        return sStudent;
        
    }    
    // get student IDs
    public List getStudentIDs(){        
        List stuIDs;        
        stuIDs=this.studentDAO.getStudentListIDs();        
        return stuIDs;        
    }  
    
    // To update student Details
    public void updateStudent() {
        this.studentDAO.updateStudent(this.searchedStudent);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Student updated successfully ", null));

        log.info("Updated Student");
    }    
    
    // To add student's details
    public void insertStudent() {
        this.studentDAO.addStudent(insertedStudent);
        setSelectedStudent(insertedStudent);
        insertedStudent = new StudentEntity();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Student Registered successfully ", null));
        log.info("Added new Student");
    }    
    
    // To search student details    
    public void searchStudent(){        
        List<StudentEntity> sStudent;
        sStudent=this.studentDAO.findStudent(firstname,grade);
        searchedStudent=null;
        if(!sStudent.isEmpty()){
            Iterator stIterator=sStudent.iterator();
            while(stIterator.hasNext()){
                searchedStudent=(StudentEntity)stIterator.next(); 
            }
        } 
        log.info("Searched Student");
    }
    
    // Navigate to response page or error page.
   public String responsePage(){
        if(searchedStudent==null)
        {
            return "error-response";
        }
        else{
            return "search-response";
        }
    } 
   
   
   // To delete student Details
    public void deleteStudent() {
        this.studentDAO.deleteStudent(this.searchedStudent);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Student Deleted successfully ", null));
        this.searchedStudent=new StudentEntity();
        log.info("Deleted Student");
    }

    public void emptyStudent(){
        selectedStudent = new StudentEntity();
        searchedStudent = new StudentEntity();
    }
    
    //Getter and Setter of the class members 

   
   
    public StudentEntity getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(StudentEntity selectedStudent) {
        this.selectedStudent = selectedStudent;
    }   

    public StudentEntity getInsertedStudent() {
        return insertedStudent;
    }

    public void setInsertedStudent(StudentEntity insertedStudent) {
        this.insertedStudent = insertedStudent;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public StudentEntity getSearchedStudent() {
        return searchedStudent;
    }

    public void setSearchedStudent(StudentEntity searchedStudent) {
        this.searchedStudent = searchedStudent;
    }

   

    
}
