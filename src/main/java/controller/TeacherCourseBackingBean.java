/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.entity.Course;
import model.entity.CourseModule;
import model.dao.CourseDAO;
import model.dao.CourseModuleDAO;
import model.entity.Assignment;
import model.dao.AssignmentDAO;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;



/**
 *
 * @author albinbecevic
 */

@Data
@Named
@ViewScoped

public class TeacherCourseBackingBean implements Serializable{
    
    @Inject
    private CourseDAO courseDao;
    
    @EJB
    private CourseModuleDAO courseModuleDao;
    
    @EJB
    private AssignmentDAO assignmentDao;
    
    private String courseID;
    private Course course;
    private List<CourseModule> moduleList;
    private CourseModule selectedCm;
    private List<Assignment> assignmentList;
    private Assignment selectedAssignment;
    
    private String assignmentID;
    private Date date;
    private String description;
    
    @PostConstruct
    public void init(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.courseID = params.get("courseID");
        this.course = courseDao.find(courseID);
        this.moduleList = courseModuleDao.findCourseModules(course);
        this.assignmentList = assignmentDao.findCourseAssignments(course);
    }
    
    public void deleteModule(){
        moduleList.remove(selectedCm);
        course.getCourseModules().remove(selectedCm);
        CourseModule removeModul = courseModuleDao.find(selectedCm.getModuleID());
        courseModuleDao.remove(removeModul);
        selectedCm = null;
    }
    
    public void deleteAssignment(){
        assignmentList.remove(selectedAssignment);
        course.getAssignments().remove(selectedAssignment);
        Assignment removeAssignment = assignmentDao.find(selectedAssignment.getAssignmentID());
        assignmentDao.remove(removeAssignment);
        selectedAssignment = null;
    }
    
    public void createAssignment(){
        assignmentID = courseIDString();
        Assignment assignment = new Assignment(assignmentID, description, date, course, new ArrayList(), new ArrayList(), null, new ArrayList());       
        courseDao.addAssignement(course, assignment);
        assignmentList.add(assignment);
    }
    
    public String getCourseID(){
        return courseID;
    }
    
    public void setCourseID(String courseID){
        this.courseID = courseID;
    }
    
    private String courseIDString(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVXYZ0123456789";
        String firstChars = "ABCDEFGHIJKLMNOPQRSTUVXYZ";
        StringBuilder builder = new StringBuilder();
        Random rand = new Random();
        
        int first_index = (int)(rand.nextFloat() * firstChars.length());
        builder.append(firstChars.charAt(first_index));
        
        while(builder.length() < 10){
            int index = (int)(rand.nextFloat() * chars.length());
            builder.append(chars.charAt(index));
        }
        
        String saltString = builder.toString();
        return saltString;
    }
}
