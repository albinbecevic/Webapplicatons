/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.AnnouncementComment;
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
public class AnnouncementCommentDAO extends AbstractDAO<AnnouncementComment, Integer>{
    @Getter @PersistenceContext(unitName = "schoolit")
    private EntityManager entityManager;
    
    public AnnouncementCommentDAO(){
        super(AnnouncementComment.class);
    }
    
    public void setTeacher(AnnouncementComment ac, Teacher t){
        ac.setTeacher(t);
        update(ac);
    }
    
    public void setStudent(AnnouncementComment ac, Student s){
        ac.setStudent(s);
        update(ac);
    }
}
