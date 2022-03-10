/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;
import model.dao.AssignmentDAO;
import model.dao.CourseDAO;
import model.entity.Assignment;
import model.entity.Course;

/**
 *
 * @author albinbecevic
 */

@Data
@Named
@ViewScoped
public class StudentAssignmentBackingBean implements Serializable{
    @EJB
    private CourseDAO courseDao;
    
    @EJB
    private AssignmentDAO assignmentDao;
    
    private String courseID;
    private Course course;
    private List<Assignment> assignmentList;
    private Assignment selectedAssignment;
    
    @PostConstruct
    public void init(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.courseID = params.get("courseID");
        System.out.println(courseID + " TESTING IS HERE!");
        this.course = courseDao.find(courseID);
        this.assignmentList = assignmentDao.findCourseAssignments(course);
    }
}
