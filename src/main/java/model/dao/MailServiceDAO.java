/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import lombok.Getter;
import model.entity.MailTemplate;
import model.entity.TemplateName;

/**
 *
 * @author albinbecevic
 */

@RequestScoped
@Transactional
public class MailServiceDAO extends AbstractDAO<MailTemplate, Integer>{
    @Getter @PersistenceContext(unitName = "schoolit_teacher")
    private EntityManager entityManager;
    
    public MailServiceDAO(){
        super(MailTemplate.class);
    }
    
    public MailTemplate findTemplateByName(TemplateName name){
        String jpql = "select mt from MailTemplate mt where mt.name = :name";
        TypedQuery<MailTemplate> query = getEntityManager().createQuery(jpql, MailTemplate.class);
        query.setParameter("name", name.name());
        
        try{
            return query.getSingleResult();
        }catch(Exception ex){
            return makeNewTemplate(name);
        }
    }
    
    private MailTemplate makeNewTemplate(TemplateName name){
        switch(name){
            case ActivationMail:
                return makeActivationMail();
            default:
                return new MailTemplate();
        }
    }
    
    private MailTemplate makeActivationMail(){
        String subject = "Acitvate SchoolIT account";
        String body = "Hello {firstname}, \r\n\r\n" + "In order to complete your registration, please click onto the following link {link}";
        MailTemplate mailTemplate = new MailTemplate();
        mailTemplate.setName(TemplateName.ActivationMail.name());
        mailTemplate.setSubject(subject);
        mailTemplate.setBody(body);
        return save(mailTemplate);
        
    }
    
}
