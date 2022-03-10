/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import model.entity.CourseModule;
import model.entity.TeacherFile;
import model.entity.Course;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import model.entity.QCourseModule;

/**
 *
 * @author albinbecevic
 */

@Stateless
public class CourseModuleDAO extends AbstractDAO<CourseModule, String>{
    @Getter @PersistenceContext(unitName = "schoolit_teacher")
    private EntityManager entityManager;
    
    public CourseModuleDAO(){
        super(CourseModule.class);
    }
    
    public void addTeacherFile(CourseModule cm, TeacherFile tf){
        cm.addTeacherFile(tf);
        update(cm);
    }
    
    public void setCourse(CourseModule cm, Course c){
        cm.setCourse(c);
        update(cm);
    }
    
    public List<CourseModule> findCourseModules(Course c){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QCourseModule courseModule = QCourseModule.courseModule;
        List<CourseModule> modules = queryFactory.selectFrom(courseModule).where(courseModule.course.eq(c)).fetch();
        return modules;
    }
}
