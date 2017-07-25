/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plexada.services;

import com.plexada.build.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
/**
 *
 * @author SAP Training
 */
@Service("emailService")
public class EmailService {
    
   private JavaMailSender javamailSender;

  @Autowired
  public EmailService(JavaMailSender javamailSender) {
    this.javamailSender = javamailSender;
  }
  
  @Async
  public void sendEmail(Company company) throws MailException {
      //send email
    SimpleMailMessage mail = new SimpleMailMessage();
    mail.setTo(company.getEmail());
    mail.setFrom("opeyemiaremu34@gmail.com");
    mail.setSubject("NSITF registration");
    mail.setText("Registration successfull");
    
    javamailSender.send(mail);
  }
    
}
