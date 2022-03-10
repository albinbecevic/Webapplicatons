/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.*;

/**
 *
 * @author albinbecevic
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Teacher implements Serializable{
    @Id
    private String teacherID;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private String userType;
    
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
    
    @OneToMany(mappedBy = "teacher")
    private List<GradingComment> gradingComments;
    
    @OneToMany
    @JoinColumn(name = "teacherID")
    private List<Grading> gradings;
    
    @OneToMany
    @JoinColumn(name = "teacherID")
    private List<Assignment> assignments;
    
    @OneToMany(mappedBy = "teacher")
    private List<AnnouncementComment> announcementComments;
    
    @OneToMany(mappedBy = "teacher")
    private List<AssignmentComment> assignmentComments;
    
    public void addCourse(Course c){
        courses.add(c);
        c.setTeacher(this);
    }
    
    public void addGradinComment(GradingComment gc){
        gradingComments.add(gc);
        gc.setTeacher(this);
    }
    
    public void addGrading(Grading g){
        gradings.add(g);
    }
    
    public void addAssignment(Assignment a){
        assignments.add(a);
    }
    
    public void addAnnouncementComment(AnnouncementComment ac){
        announcementComments.add(ac);
        ac.setTeacher(this);
    }
    
    public void addAssignemntComment(AssignmentComment agc){
        assignmentComments.add(agc);
        agc.setTeacher(this);
    }
}



