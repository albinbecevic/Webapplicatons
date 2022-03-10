/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import model.entity.Assignment;
import model.entity.TeacherFile;
import model.entity.StudentFile;
import model.entity.AssignmentComment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import model.entity.Course;
import model.entity.QAssignment;

/**
 *
 * @author albinbecevic
 */

@Stateless
public class AssignmentDAO extends AbstractDAO<Assignment, String>{
    @Getter @PersistenceContext(unitName = "schoolit_teacher")
    private EntityManager entityManager;
    
    public AssignmentDAO(){
        super(Assignment.class);
    }
    
    public void addTeacherFile(Assignment a, TeacherFile tf){
        a.addTeacherFile(tf);
        update(a);
    }
    
    public void addStudentFile(Assignment a, StudentFile sf){
        a.addStudentFile(sf);
        update(a);
    }
    
    public void addAssignmentComment(Assignment a, AssignmentComment ac){
        a.addAssignmentComment(ac);
        update(a);
    }
    
    public List<Assignment> findCourseAssignments(Course c){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QAssignment assignment = QAssignment.assignment;
        List<Assignment> assignments = queryFactory.selectFrom(assignment).where(assignment.course.eq(c)).fetch();
        return assignments;
    }
}
