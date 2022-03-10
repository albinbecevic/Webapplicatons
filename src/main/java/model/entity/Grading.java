/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Grading implements Serializable{
    @Id
    private int gradingID;
    private boolean accepted;
    private String comment;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date time_Stamp;
    
    @OneToMany(mappedBy = "grading")
    private List<GradingComment> gradingComments = new ArrayList<>();
    
    
    public void addGradingComment(GradingComment gc){
        gradingComments.add(gc);
        gc.setGrading(this);
    }
}
