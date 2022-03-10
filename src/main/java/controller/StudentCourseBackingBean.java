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
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
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
public class StudentCourseBackingBean implements Serializable{
    
    @Inject
    private CourseDAO courseDao;
    
    @Inject
    BeanManager beanManager;
    
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
        this.moduleList = course.getCourseModules();
    }
    
    public void test(){
        System.out.println("We are testing here : " + courseID);
    }
    
    public String getCourseID(){
        return null;
    }
    
    /*
        We were here when we ended, keep working here
    */
    public String backAction(){
        System.out.println("We killed the session");
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        Bean<StudentCourseBackingBean> bean = (Bean<StudentCourseBackingBean>)beanManager.resolve(beanManager.getBeans(StudentCourseBackingBean.class));
        StudentCourseBackingBean studentCourseBackingBean = (StudentCourseBackingBean)beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean));
        studentCourseBackingBean = null;
        
        return "/member/StudentHomePage.xhtml";
    }
}
