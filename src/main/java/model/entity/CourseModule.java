/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class CourseModule implements Serializable{
    @Id
    private String moduleID;
    private String week;
    private String topic;
    private String lectureDescp;
    private String exercises;
    
    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    private Course course;
    
    @ManyToMany(mappedBy = "courseModules", cascade = CascadeType.PERSIST)
    private List<TeacherFile> teacherFiles;
    
    public void addTeacherFile(TeacherFile tf){
        teacherFiles.add(tf);
    }
    
    public void setCourse(Course c){
        this.course = c;
    }
}
