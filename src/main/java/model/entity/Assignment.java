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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Assignment implements Serializable{
    @Id
    private String assignmentID;
    private String Description;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date time_Stamp;
    
    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    private Course course;
    
    @OneToMany
    @JoinColumn(name = "teacherFileID")
    private List<TeacherFile> teacherFiles;
    
    @OneToMany
    @JoinColumn(name = "studentFilesID")
    private List<StudentFile> studentFiles;
    
    @OneToOne
    @JoinColumn(name = "fk_grading")
    private Grading grading;    
    
    @OneToMany
    @JoinColumn(name = "assignmentCommentID")
    private List<AssignmentComment> assignmentComments;
    
    public void addTeacherFile(TeacherFile tf){
        teacherFiles.add(tf);
    }
    
    public void addStudentFile(StudentFile sf){
        studentFiles.add(sf);
    }
    
    public void addAssignmentComment(AssignmentComment ac){
        assignmentComments.add(ac);
    }
}
