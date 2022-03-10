/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author albinbecevic
 */

@Entity
@Data
public class MailTemplate implements Serializable{
    
    @Id
    private String id = UUID.randomUUID().toString();   
    private String name;   
    private String subject;
    private String body;
}
