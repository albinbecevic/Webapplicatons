/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.StudentFile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author albinbecevic
 */

@Stateless
public class StudentFileDAO extends AbstractDAO<StudentFile, Integer>{
    @Getter @PersistenceContext(unitName = "schoolit")
    private EntityManager entityManager;
    
    public StudentFileDAO(){
        super(StudentFile.class);
    }    
    
}
