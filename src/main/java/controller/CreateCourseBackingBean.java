/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package controller;

import java.io.Serializable;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;

import model.dao.CourseDAO;
import model.dao.TeacherDAO;
import model.entity.Teacher;
import model.entity.Course;
import model.entity.CourseModule;
import model.dao.CourseModuleDAO;
import model.entity.Assignment;
import model.dao.AssignmentDAO;



/**
 *
 * @author albinbecevic
 */

@Data
@Named
@ViewScoped

public class CreateCourseBackingBean implements Serializable{
    
    @Inject
    private TeacherDAO teacherDao;
    
    @EJB
    private CourseDAO courseDao;
    
    @EJB
    private CourseModuleDAO courseModuleDao;
    
    @EJB
    private AssignmentDAO assignmentDao;
    
    @Inject 
    SecurityContext securityContext;
    
    // Attributes for creating course
    private Teacher currentTeacher;
    private String courseName;
    private String courseID;
    
    // Attributes for creating a syllabus
    private String moduleID;
    private Date date;
    private String topic;
    private String recReading;
    private String recAssignments;
    private List<CourseModule> modulesList;
    
    // Attributes for creating assignment
    private String assignmentID;
    private String assignmentHeader;
    private String description;
    private List<Assignment> assignmentList;
    
    private Assignment selectedAssignment;
    private CourseModule selectedCm;
    
    @PostConstruct
    public void init(){
        String email = securityContext.getCallerPrincipal().getName();
        this.currentTeacher = teacherDao.findTeacher(email);
        this.courseID = courseIDString();
        this.modulesList = new ArrayList<>();
        this.assignmentList = new ArrayList<>();
    }
    
    
    public void createCourse(){
        Course course = new Course(courseID, courseName, currentTeacher, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        course.setTeacher(currentTeacher);
        teacherDao.addCourse(currentTeacher, course);
    }
    
    /*
    Create a random course ID string used for key in database and
    student join key for course.
    */
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
    
    public void setCourseID(String courseID){
        this.courseID = courseID;
    }
    
    public void createModule(){
        moduleID = courseIDString();
        Course course = courseDao.find(courseID);
        CourseModule cm = new CourseModule(moduleID, date.toString(), topic, recReading, recAssignments, course, new ArrayList());
        courseDao.addCourseModule(course, cm);
        modulesList.add(cm);           
    }
    
    
    public void deleteModule(){
        modulesList.remove(selectedCm);
        Course course = courseDao.find(courseID);
        course.getCourseModules().remove(selectedCm);
        CourseModule removeModul = courseModuleDao.find(selectedCm.getModuleID());
        courseModuleDao.remove(removeModul);
        selectedCm = null;
    }
    
    
    public void setSelectedModule(CourseModule selectedCm){
        this.selectedCm = selectedCm;
    }
    
    public void createAssignment(){
        assignmentID = courseIDString();
        Course course = courseDao.find(courseID);
        Assignment assignment = new Assignment(assignmentID, description, date, course, new ArrayList(), new ArrayList(), null, new ArrayList());
        courseDao.addAssignement(course, assignment);
        assignmentList.add(assignment);      
    }
    
    public void setSelectedAssignment(Assignment selectedAssignment){
        this.selectedAssignment = selectedAssignment;
    }
    
    public void deleteAssignment(){
        assignmentList.remove(selectedAssignment);
        Course course = courseDao.find(courseID);
        course.getAssignments().remove(selectedAssignment);
        Assignment removeAssignment = assignmentDao.find(selectedAssignment.getAssignmentID());
        assignmentDao.remove(removeAssignment);
        selectedAssignment = null;
    }
    
    public String returnAction(){
        return "/member/TeacherHomePage.xhtml?faces-redirect=true";
    }
}
