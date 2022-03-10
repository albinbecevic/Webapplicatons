/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
public class TeacherFile implements Serializable{
    @Id
    private int fileID;
    private String title;    
    @Lob
    private String content;
    
    private int courseID;
    //private int moduleID;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "modules_teacherFiles", joinColumns = @JoinColumn(name = "fileID"), inverseJoinColumns = @JoinColumn(name = "moduleID"))
    private List<CourseModule> courseModules;
    
    public TeacherFile(int fileID, String title, String content, int courseID/*, int moduleID*/){
        this.fileID = fileID;
        this.title = title;
        this.content = content;
        this.courseID = courseID;
        /*this.moduleID = moduleID;*/
        courseModules = new ArrayList<>();
    }
    
    public void addModule(CourseModule m){
        courseModules.add(m);
        m.addTeacherFile(this);
    }
}
