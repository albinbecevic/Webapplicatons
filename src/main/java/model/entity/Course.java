/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.List;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author albinbecevic
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable{
    @Id
    private String courseID;
    private String courseName;
    
    @ManyToOne
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Teacher teacher;
    
    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<CourseModule> courseModules;
    
    @ManyToMany(mappedBy = "courses")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Student> students;
    
    /*
    @OneToMany
    @JoinColumn(name = "courseID")
    private List<Assignment> assignments;
    */
    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Assignment> assignments;
    
    @OneToMany
    @JoinColumn(name = "courseID")
    private List<Announcement> announcements;
    
    public void addStudent(Student s){
        students.add(s);
        s.addCourse(this);
    }
    
    public void addModule(CourseModule cm){
        courseModules.add(cm);
        cm.setCourse(this);
    }
    
    public void addAssignment(Assignment a){
        assignments.add(a);        
    }
    
    public void addAnnouncement(Announcement am){
        announcements.add(am);
    }
    
    public void setTeacher(Teacher t){
        teacher = t;
    }
}
