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


import java.io.Serializable;
import java.util.List;
import java.util.Map;
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
public class StudentSyllabusBackingBean implements Serializable{
    
    @Inject
    private CourseDAO courseDao;
    
    @EJB
    private CourseModuleDAO courseModuleDao;
    
    private String courseID;
    private Course course;
    private List<CourseModule> moduleList;
    private CourseModule selectedCm;
    
    @PostConstruct
    public void init(){
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        this.courseID = params.get("courseID");
        System.out.println(courseID + " TESTING IS HERE!");
        this.course = courseDao.find(courseID);
        this.moduleList = courseModuleDao.findCourseModules(course);
    }
}
