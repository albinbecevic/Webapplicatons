/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.GradingComment;
import model.entity.Teacher;
import model.entity.Student;
import model.entity.Grading;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author albinbecevic
 */
@Stateless
public class GradingCommentDAO extends AbstractDAO <GradingComment, Integer>{
    @Getter @PersistenceContext(unitName = "schoolit")
    private EntityManager entityManager;
    
    public GradingCommentDAO(){
        super(GradingComment.class);
    }
    
    public void setTeacher(GradingComment gc, Teacher t){
        gc.setTeacher(t);
        update(gc);
    }
    
    public void setStudent(GradingComment gc, Student s){
        gc.setStudent(s);
        update(gc);
    }
    
    public void setGrading(GradingComment gc, Grading g){
        gc.setGrading(g);
        update(gc);
    }
}
