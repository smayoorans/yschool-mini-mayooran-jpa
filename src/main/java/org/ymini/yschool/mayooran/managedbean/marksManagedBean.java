
package org.ymini.yschool.mayooran.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.ymini.yschool.mayooran.entitymodel.ResultEntity;
import org.ymini.yschool.mayooran.entitymodel.ResultEntityDAO;


@ManagedBean
@SessionScoped
public class marksManagedBean {
    
    private static final Logger log = Logger.getLogger(marksManagedBean.class);
    private ResultEntity insertedResult;
    ResultEntityDAO resultDAO;
    
    public marksManagedBean() {
        this.insertedResult=new ResultEntity();
        this.resultDAO = new  ResultEntityDAO();
    }
    
    // To add student's marks details
    public void insertResult() {
        this.resultDAO.addResult(insertedResult);        
        log.info("Added marks to "+insertedResult.getStudentid());
        insertedResult = new ResultEntity();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Marks entered successfully ", null));
    }

    public ResultEntity getInsertedResult() {
        return insertedResult;
    }

    public void setInsertedResult(ResultEntity insertedResult) {
        this.insertedResult = insertedResult;
    }
    
}
