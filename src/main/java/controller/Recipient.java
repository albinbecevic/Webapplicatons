/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.mail.Message.RecipientType;

/**
 *
 * @author albinbecevic
 */
public class Recipient {
    private final String email;
    private final RecipientType rType;
    
    public Recipient(String email, RecipientType rType){
        this.email = email.trim();
        this.rType = rType;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public RecipientType getType(){
        return this.rType;
    }
}
