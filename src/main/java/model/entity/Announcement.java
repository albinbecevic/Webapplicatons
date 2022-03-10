/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.List;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author albinbecevic
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Announcement implements Serializable{
    @Id
    private int announcementID;
    private String content;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date time_Stamp;
    
    @OneToMany
    @JoinColumn(name = "announcementID")
    private List<AnnouncementComment> announcementComments;
    
    
    public void addAnnouncementComment(AnnouncementComment ac){
        announcementComments.add(ac);       
    }
}
