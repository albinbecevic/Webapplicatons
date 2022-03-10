/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.sql.Clob;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
public class StudentFile implements Serializable{
    @Id
    private int fileID;
    private String title;
    
    @Lob
    private Clob content;
}
