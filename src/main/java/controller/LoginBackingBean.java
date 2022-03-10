/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import lombok.Data;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletResponse;

import model.dao.TeacherDAO;

/**
 *
 * @author albinbecevic
 */

@Data
@Named
@RequestScoped
public class LoginBackingBean implements Serializable{
    
    @NotEmpty
    private String email;
    
    @NotEmpty
    private String password;
    
    @EJB
    private TeacherDAO teacherDao;
    
    @Inject
    FacesContext facesContext;
    
    @Inject
    SecurityContext securityContext;
    
    @Inject
    public LoginBackingBean(){
        
    }   
    
    private boolean isTeacher(String email){
        boolean result = teacherDao.findTeacher(email) != null;
        System.out.print(result);
        return teacherDao.findTeacher(email) != null;
    }
    
    public void login() throws IOException{      
        if (isTeacher(email)) {
            switch (processAuthentication()) {
                case SEND_CONTINUE:
                    facesContext.responseComplete();
                    break;
                case SEND_FAILURE:
                    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
                    break;
                case SUCCESS:
                    getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/member/TeacherHomePage.xhtml");
                    break;
            }
        } else {

            switch (processAuthentication()) {
                case SEND_CONTINUE:
                    facesContext.responseComplete();
                    break;
                case SEND_FAILURE:
                    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));
                    break;
                case SUCCESS:
                    getExternalContext().redirect(getExternalContext().getRequestContextPath() + "/member/StudentHomePage.xhtml");
                    break;
            }

        }
    }
    
    private AuthenticationStatus processAuthentication(){
        ExternalContext ec = getExternalContext();
        
        return securityContext.authenticate((HttpServletRequest)ec.getRequest(), 
                                            (HttpServletResponse)ec.getResponse(), 
                                            AuthenticationParameters.withParams().credential(new UsernamePasswordCredential(email, password)));
    }
    
    private ExternalContext getExternalContext(){
        return facesContext.getExternalContext();
    }
    
    public String logout() throws ServletException{
        ExternalContext ec = facesContext.getExternalContext();
        ((HttpServletRequest)ec.getRequest()).logout();
        return "/index.xhtml?faces-redirect=true";
    }
}
