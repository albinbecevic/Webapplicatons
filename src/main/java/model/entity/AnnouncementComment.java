/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class AnnouncementComment implements Serializable{
    @Id
    private int AnnouncementCommentID;
    private String content;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date time_Stamp;
    
    @ManyToOne
    @JoinColumn(name = "fk_student")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "fk_teacher")
    private Teacher teacher;
    
    
    public void setStudent(Student s){
        student = s;
    }
    
    public void setTeacher(Teacher t){
        teacher = t;
    }
}
