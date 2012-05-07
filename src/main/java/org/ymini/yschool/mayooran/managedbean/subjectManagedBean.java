
package org.ymini.yschool.mayooran.managedbean;

import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.ymini.yschool.mayooran.entitymodel.SubjectEntity;
import org.ymini.yschool.mayooran.entitymodel.SubjectEntityDAO;


@ManagedBean
@SessionScoped
public class subjectManagedBean {
    
   private static final Logger log = Logger.getLogger(subjectManagedBean.class);
    
    private SubjectEntity insertedSubject;
    private SubjectEntity selectedSubject;
    private SubjectEntity searchedSubject;    
   
    private String subjectname;
    private List<SubjectEntity> sSubject;
    SubjectEntityDAO subjectDAO;
    
   public subjectManagedBean() {
        
        this.insertedSubject = new SubjectEntity();
        this.selectedSubject=new SubjectEntity();
        this.searchedSubject=new SubjectEntity();       
        
        this.subjectDAO = new  SubjectEntityDAO();

        log.info("Initiated SubjectManagedBean");
    }

    public List<SubjectEntity> getSubjectList() {
        return this.subjectDAO.getSubjectList();
    }    
    
    // To update subject Details
    public void updateSubject() {
        this.subjectDAO.updateSubject(this.searchedSubject);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Subject updated successfully ", null));

        log.info("Updated Subject");
    }    
    
    // To add subject's details
    public void insertSubject() {
        this.subjectDAO.addSubject(insertedSubject);
        setSelectedSubject(insertedSubject);
        insertedSubject = new SubjectEntity();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Subject Registered successfully ", null));
        log.info("Added new Subject");
    }    
    
    // To search subject details    
    public void searchSubject(){        
        
        sSubject=this.subjectDAO.findSubject(subjectname);
        searchedSubject=null;
        if(!sSubject.isEmpty()){
            Iterator stIterator=sSubject.iterator();
            while(stIterator.hasNext()){
                searchedSubject=(SubjectEntity)stIterator.next(); 
            }
        } 
        log.info("Searched Subject");
  }
    
        // Navigate to response page or error page.
    public String responsePage(){
            if(searchedSubject==null)
            {
                return "subject-response";
            }
            else{
                return "subject-response";
            }
        } 

   
   // To delete subject Details
    public void deleteSubject() {
        this.subjectDAO.deleteSubject(this.searchedSubject);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Subject Deleted successfully ", null));
        this.searchedSubject=new SubjectEntity();
        log.info("Deleted Subject");
    }
    
    // get subject IDs
    public List getSubjectIDs(){        
        List subIDs;        
        subIDs=this.subjectDAO.getSubjectListIDs();        
        return subIDs;        
    }  
    
    //Getters and Setters

    public SubjectEntity getInsertedSubject() {
        return insertedSubject;
    }

    public void setInsertedSubject(SubjectEntity insertedSubject) {
        this.insertedSubject = insertedSubject;
    }

    public List<SubjectEntity> getsSubject() {
        return sSubject;
    }

    public void setsSubject(List<SubjectEntity> sSubject) {
        this.sSubject = sSubject;
    }

    public SubjectEntity getSearchedSubject() {
        return searchedSubject;
    }

    public void setSearchedSubject(SubjectEntity searchedSubject) {
        this.searchedSubject = searchedSubject;
    }

    public SubjectEntity getSelectedSubject() {
        return selectedSubject;
    }

    public void setSelectedSubject(SubjectEntity selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    
    
}

