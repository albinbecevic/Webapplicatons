/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author albinbecevic
 */

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import lombok.Data;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.UUID;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import model.dao.StudentDAO;
import model.entity.Student;
import org.primefaces.PrimeFaces;

/**
 *
 * @author albinbecevic
 */

@Data
@Named
@RequestScoped
public class CreateStudentBackingBean implements Serializable{
    private String email;
    private String firstName;
    private String lastName;
    private String organisation;
    private String password;
    private String confirmPassword;
    private boolean accountExist;
    
    @EJB
    private StudentDAO studentDao;
    
    @Inject
    Pbkdf2PasswordHash passwordHasher;
    
    @PostConstruct
    public void init(){ 
        
    }
    
    public boolean checkFields(){
        return email == null || firstName == null || lastName == null || organisation == null || password == null || confirmPassword == null;
    }
    
    public boolean checkExistingAcc(){
        return studentDao.findStudent(email) != null;
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
        Student s = new Student(generateId(), firstName, lastName, passwordHasher.generate(password.toCharArray()), email, "student", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        studentDao.create(s);

        return "index";
    }
    
    private String generateId(){
        String id = UUID.randomUUID().toString();
        return id;
    }
}
