/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.AssignmentComment;
import model.entity.Teacher;
import model.entity.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author albinbecevic
 */

@Stateless
public class AssignmentCommentDAO extends AbstractDAO<AssignmentComment, Integer>{
    @Getter @PersistenceContext(unitName = "schoolit")
    private EntityManager entityManager;
    
    public AssignmentCommentDAO(){
        super(AssignmentComment.class);
    }
    
    public void setTeacher(AssignmentComment ac, Teacher t){
        ac.setTeacher(t);
        update(ac);
    }
    
    public void setStudent(AssignmentComment ac, Student s){
        ac.setStudent(s);
        update(ac);
    }
}
