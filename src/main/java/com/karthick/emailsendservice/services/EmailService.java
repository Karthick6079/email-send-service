package com.karthick.emailsendservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.karthick.emailsendservice.entities.EmailDetails;
import com.karthick.emailsendservice.interfaces.EmailServiceInterface;



@Service
public class EmailService implements EmailServiceInterface{
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	
	public String sendEmail(EmailDetails emailDetails) {
		return this.sendSimpleEmail(emailDetails);
//		if(!"".equals(emailDetails.getAttachmentPath())) {
//			return this.sendEmailWithAttachment(emailDetails);
//		} else {
//			return this.sendSimpleEmail(emailDetails);
//		}
	}

	@Override
	public String sendSimpleEmail(EmailDetails emailDetails) {
		
		try {
			
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(sender);
			simpleMailMessage.setTo(emailDetails.getEmailTo());
			simpleMailMessage.setSubject(emailDetails.getSubject());
			simpleMailMessage.setText(emailDetails.getMessage());
			
			javaMailSender.send(simpleMailMessage);
			
		}catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		} 
		
		return "OK";
	}

	@Override
	public String sendEmailWithAttachment(EmailDetails emailDetails) {
		// TODO Auto-generated method stub
		return null;
	}

}
