/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.entity.Teacher;
import model.dao.TeacherDAO;
import model.entity.Student;
import model.dao.StudentDAO;
import model.entity.Course;
import model.dao.CourseDAO;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import lombok.Data;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author albinbecevic
 */

@Data
@Named
@RequestScoped

public class StudentDashboardView implements Serializable{
    @Inject
    private TeacherDAO teacherDao;
    
    @Inject
    private StudentDAO studentDao;
    
    @Inject
    private CourseDAO courseDao;
    
    @Inject
    private SecurityContext securityContext;
    
    private Student currentStudent;
    private Teacher currentTeacher;
    private List<Course> courseList;
    private DashboardModel model;
    private String courseCodeSearch;
    
    @PostConstruct
    public void init() {
        String email = securityContext.getCallerPrincipal().getName();
        userTypeSetup(email);
        courseListSetup();       
        dashBoardSetup();
    }

    public void handleReorder(DashboardReorderEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Reordered: " + event.getWidgetId());
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());

        addMessage(message);
    }

    public void handleClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");

        addMessage(message);
    }

    public void handleToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public DashboardModel getModel() {
        return model;
    }
    
    public void createAction(){
        //return "/member/TeacherCreateCourse.xhtml";
    }
    
    public void dashBoardSetup(){
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
        DashboardColumn column3 = new DefaultDashboardColumn();
        DashboardColumn column4 = new DefaultDashboardColumn();
        DashboardColumn column5 = new DefaultDashboardColumn();
        
        column1.addWidget("createCourse");

        int counter = 2;       
        for (Course course : courseList){
            if (counter % 5 == 0){
                counter = 1;
            }
            switch(counter){
                case 1:
                    column1.addWidget(course.getCourseID());
                    break;                   
                case 2:
                    //System.out.println("Did we get to case 2");
                    column2.addWidget(course.getCourseID());
                    break;
                case 3:
                    column3.addWidget(course.getCourseID());
                    break;
                case 4:
                    column4.addWidget(course.getCourseID());
                    break;
                case 5:
                    column5.addWidget(course.getCourseID());
                    break;
            }
        }
        
        model.addColumn(column1);
        model.addColumn(column2);
        model.addColumn(column3);
        model.addColumn(column4);
        model.addColumn(column5);
    }
    
    public void test(){
        courseList = this.currentTeacher.getCourses();
        if(courseList == null){
            System.out.println("Its NULL");
        }else{
            System.out.println("Its not null");
        }
        
    }
    
    private void userTypeSetup(String email){
        if(teacherDao.findTeacher(email) != null){
            currentTeacher = teacherDao.findTeacher(email);
        }else{
            currentStudent = studentDao.findStudent(email);
        }
    }
    
    private void courseListSetup(){
        if(currentTeacher != null){
            courseList = currentTeacher.getCourses();
        }else{
            courseList = currentStudent.getCourses();
        }
    }
    
  
    
    public String joinCourse(){     
        if(courseDao.find(courseCodeSearch) != null){
            System.out.println("We found course");
            Course c = courseDao.find(courseCodeSearch);
            studentDao.addCourse(currentStudent, c);
            return "/member/StudentHomePage.xhtml?faces-redirect=true";
        }else{
            System.out.println("Did not found course, return null");
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No course with that code exist", null));
            return null;
        }
    }
}
