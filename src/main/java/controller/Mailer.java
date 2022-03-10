/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.annotation.Resource;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import java.io.File;
import javax.inject.Inject;
import model.dao.MailServiceDAO;
import model.entity.MailTemplate;
import model.entity.TemplateName;

/**
 *
 * @author albinbecevic
 */

@Dependent
public class Mailer implements Serializable{
    protected static final Logger LOGGER = Logger.getLogger("Mailer");
    
    @Inject
    private MailServiceDAO mailService;
    
    @Resource(lookup = "schoolit_mail")
    private Session session;
    
    public boolean sendMail(String to, String subject, String body){
        List<Recipient> recipients =new ArrayList<>();
        recipients.add(new Recipient(to, RecipientType.TO));
        return sendMail(recipients, subject, body);
    }
    
    public boolean sendMail(List<Recipient> recipients, String subject, String body, String...files){
        try{
            MimeMessage message = composeMessage(recipients, subject, body, files);
            String user = session.getProperty("mail.user");
            String password = session.getProperty("mail.smpt.password");
            Transport.send(message, user, password);
            return true;
        }catch(MessagingException ex){
            LOGGER.log(Level.SEVERE, "Mailer failed: {0}", ex.getMessage());
            return false;
        }
    }
    
    private MimeMessage composeMessage(List<Recipient> recipients, String subject, String body, String[] files) throws MessagingException{
        MimeMessage message = new MimeMessage(session);
        for(Recipient recipient : recipients){
            message.addRecipient(recipient.getType(), new InternetAddress(recipient.getEmail()));
        }
        message.setSubject(subject);
        message.setContent(getMultipartBody(body, files));
        String from = session.getProperty("mail.from");
        message.setFrom(new InternetAddress(from));
        return message;
    }
    
    private MimeMultipart getMultipartBody(String body, String[] files) throws MessagingException{
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(body);
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        for(String file : files){
            addAttachment(multipart, file);
        }
        return multipart;
    }
    
    private static void addAttachment(MimeMultipart multipart, String filename) throws MessagingException{
        if(filename.isEmpty()){
            return;
        }
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        File file = new File(filename);
        messageBodyPart.setFileName(file.getName());
        multipart.addBodyPart(messageBodyPart);
    }
    
    public MailTemplate findTemplateByName(TemplateName templateName){
        return mailService.findTemplateByName(templateName);
    }
}
