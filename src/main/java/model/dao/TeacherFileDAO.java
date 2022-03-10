/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.TeacherFile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import model.entity.CourseModule;

/**
 *
 * @author albinbecevic
 */

@Stateless
public class TeacherFileDAO extends AbstractDAO<TeacherFile, Integer>{
    @Getter @PersistenceContext(unitName = "schoolit")
    private EntityManager entityManager;
    
    public TeacherFileDAO(){
        super(TeacherFile.class);
    }
    
    public void addCourseModule(TeacherFile tf, CourseModule cm){
        tf.addModule(cm);
        update(tf);
    }
}
