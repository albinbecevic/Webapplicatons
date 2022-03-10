/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import lombok.Data;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import java.util.UUID;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.servlet.http.HttpServletRequest;



import model.dao.TeacherDAO;
import model.entity.MailTemplate;
import model.entity.Teacher;
import model.entity.TemplateName;
import org.primefaces.PrimeFaces;
import java.util.logging.Logger;


/**
 *
 * @author albinbecevic
 */

@Data
@Named
@RequestScoped
public class CreateTeacherBackingBean implements Serializable{
    private String email;
    private String firstName;
    private String lastName;
    private String organisation;
    private String password;
    private String confirmPassword;
    private boolean accountExist;
    
    @EJB
    private TeacherDAO teacherDao;
    
    @Inject
    Pbkdf2PasswordHash passwordHasher;
    
    @Inject
    private Mailer mailer;
    
    @PostConstruct
    public void init(){  

    }
    
    public boolean checkFields(){
        return email == null || firstName == null || lastName == null || organisation == null || password == null || confirmPassword == null;
    }
    
    // In progress function
    
    public boolean checkExistingAcc(){
        return teacherDao.findTeacher(email) != null;
    }
    
    
    
     public String createAccount() {       
        if (checkFields()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR:", " Did not fill in required fields!");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        }
        if(checkExistingAcc()){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERROR", "Account already exists!");
            PrimeFaces.current().dialog().showMessageDynamic(message);
            return null;
        }
        
        String id = generateId();
        Teacher t = new Teacher(generateId(), firstName, lastName, passwordHasher.generate(password.toCharArray()), email, "teacher", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        teacherDao.create(t);
        
        /* The mail functionality have to be put on hold, since cant figure out why 
           the application can't connect to the SMTP host. */
        //sendEmail();

        return "index";
    }
    
    private String generateId(){
        String id = UUID.randomUUID().toString();
        return id;
    }
    
    private void sendEmail(){
        MailTemplate template = mailer.findTemplateByName(TemplateName.ActivationMail);
        String subject = template.getSubject();
        String body = template.getBody().replace("{firstaName}", firstName).replace("{link}", "index.xhtml");
        mailer.sendMail(email, subject, body);
    }
    
    private String getUrl(String key){
        HttpServletRequest request = obtainServletRequest();
        try{
            URL url = new URL(request.getScheme(), 
                    request.getServerName(), 
                    request.getServerPort(), 
                    request.getContextPath() + "/activation.xhtml" + "?key=" + key);
            return url.toString();
        }catch(MalformedURLException ex){
            Logger.getLogger(firstName).log(Level.SEVERE,null, ex);
            return "";
        }
    }
    
    private HttpServletRequest obtainServletRequest(){
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest)context.getExternalContext().getRequest();
    }
}
