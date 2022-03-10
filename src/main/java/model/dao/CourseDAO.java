/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import model.entity.Course;
import model.entity.CourseModule;
import model.entity.Student;
import model.entity.Assignment;
import model.entity.Announcement;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import model.entity.QAssignment;
import model.entity.QCourse;

/**
 *
 * @author albinbecevic
 */
@Stateless
public class CourseDAO extends AbstractDAO<Course, String>{
    @Getter @PersistenceContext(unitName = "schoolit_teacher")
    private EntityManager entityManager;
    
    public CourseDAO(){
        super(Course.class);
    }
    
    public List<Course> findCarsMatchingName(){
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public void addCourseModule(Course c, CourseModule cm){
        c.addModule(cm);
        update(c);
    }
    
    public void addStudents(Course c, Student s){
        c.addStudent(s);
        update(c);
    }
    
    public void addAssignement(Course c, Assignment a){
        c.addAssignment(a);
        update(c);
    }
    
    public void addAnnouncement(Course c, Announcement am){
        c.addAnnouncement(am);
        update(c);
    }
    
    public List<Assignment> findCourseAssignments(Course c){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QCourse course = QCourse.course;
        QAssignment assignment = QAssignment.assignment;
        List<Assignment> assignments = queryFactory.select(course.assignments).from(course).leftJoin(assignment).on(course.courseID.eq(c.getCourseID())).fetchFirst();
        return assignments;
    }
}
