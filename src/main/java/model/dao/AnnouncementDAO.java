/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.Announcement;
import model.entity.AnnouncementComment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author albinbecevic
 */

@Stateless
public class AnnouncementDAO extends AbstractDAO<Announcement, Integer> {
    @Getter @PersistenceContext(unitName = "schoolit")
    private EntityManager entityManager;
    
    public AnnouncementDAO(){
        super(Announcement.class);
    }
    
    public void addAnnouncmentComment(Announcement a, AnnouncementComment ac){
        a.addAnnouncementComment(ac);
        update(a);
    }
}
