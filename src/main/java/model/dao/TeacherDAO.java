/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import model.entity.Teacher;
import model.entity.Course;
import model.entity.Grading;
import model.entity.Assignment;
import model.entity.AnnouncementComment;
import model.entity.AssignmentComment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import model.entity.QTeacher;

/**
 *
 * @author albinbecevic
 */
@Stateless
public class TeacherDAO extends AbstractDAO<Teacher, Integer>{
    @Getter @PersistenceContext(unitName = "schoolit_teacher")
    private EntityManager entityManager;
    
    public TeacherDAO(){
        super(Teacher.class);
    }
    
    public void addCourse(Teacher t, Course c){
        t.addCourse(c);
        update(t);
    }
    
    public void addGrading(Teacher t, Grading g){
        t.addGrading(g);
        update(t);
    }
    
    public void addAssignment(Teacher t, Assignment a){
        t.addAssignment(a);
        update(t);
    }
    
    public void addAnnouncementComment(Teacher t, AnnouncementComment ac){
        t.addAnnouncementComment(ac);
        update(t);
    }
    
    public void addAssignmentComment(Teacher t, AssignmentComment agc){
        t.addAssignemntComment(agc);
        update(t);
    }
    
    public Teacher findTeacher(String email){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QTeacher teacher = QTeacher.teacher;
        Teacher t = queryFactory.selectFrom(teacher).where(teacher.email.eq(email)).fetchOne();
        return t;
    }
}
