/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.Grading;
import model.entity.GradingComment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author albinbecevic
 */

@Stateless
public class GradingDAO extends AbstractDAO<Grading, Integer>{
    @Getter @PersistenceContext(unitName = "schoolit")
    private EntityManager entityManager;
    
    public GradingDAO(){
        super(Grading.class);
    }
    
    public void addGradingComment(Grading g, GradingComment gc){
        g.addGradingComment(gc);
        update(g);
    }
}
