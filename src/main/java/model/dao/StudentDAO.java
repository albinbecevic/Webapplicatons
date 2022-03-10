/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import model.entity.Student;
import model.entity.Course;
import model.entity.Assignment;
import model.entity.AnnouncementComment;
import model.entity.GradingComment;
import model.entity.AssignmentComment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import model.entity.QStudent;

/**
 *
 * @author albinbecevic
 */
@Stateless
public class StudentDAO extends AbstractDAO<Student, Integer>{
    @Getter @PersistenceContext(unitName = "schoolit_teacher")
    private EntityManager entityManager;
    
    public StudentDAO(){
        super(Student.class);
    }
    
    public void addCourse(Student s, Course c){
        c.addStudent(s);
        update(s);
    }
    
    public void addAssignment(Student s, Assignment a){
        s.addAssignment(a);
        update(s);
    }
    
    public void addAnnouncementComment(Student s, AnnouncementComment ac){
        s.addAnnouncementComment(ac);
        update(s);
    }
    
    public void addGradingComment(Student s, GradingComment gc){
        s.addGradingComment(gc);
        update(s);
    }
    
    public void addAssignmentComment(Student s, AssignmentComment agc){
        s.addAssignmentComment(agc);
        update(s);
    }
    
    
    public Student findStudent(String email){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QStudent student = QStudent.student;
        Student s = queryFactory.selectFrom(student).where(student.email.eq(email)).fetchOne();
        return s;
    }
}
