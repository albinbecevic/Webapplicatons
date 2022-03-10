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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
public class Student implements Serializable{
    @Id
    private String studentID;
    private String name;
    private String lastName;
    //private String userName;
    private String password;
    private String email;
    private String userType;
      
    @ManyToMany
    @JoinTable(name = "studentCourse", joinColumns = @JoinColumn(name = "studentID"), inverseJoinColumns = @JoinColumn(name = "course_ID"))
    private List<Course> courses;
    
    @OneToMany
    @JoinColumn(name = "assigmentID")
    private List<Assignment> assignments;
    
    @OneToMany(mappedBy = "student")
    private List<AnnouncementComment> announcementComments;
    
    @OneToMany(mappedBy = "student")
    private List<GradingComment> gradingComments;
    
    @OneToMany(mappedBy = "student")
    private List<AssignmentComment> assignmentComments;
    
    public void addCourse(Course c){
        courses.add(c);
        //c.addStudent(this);
    }
    
    public void addAssignment(Assignment a){
        assignments.add(a);
    }
    
    public void addAnnouncementComment(AnnouncementComment ac){
        announcementComments.add(ac);
        ac.setStudent(this);
    }
    
    public void addGradingComment(GradingComment gc){
        gradingComments.add(gc);
        gc.setStudent(this);
    }
    
    public void addAssignmentComment(AssignmentComment agc){
        assignmentComments.add(agc);
        agc.setStudent(this);
    }
}
