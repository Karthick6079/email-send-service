package com.karthick.emailsendservice.interfaces;

import com.karthick.emailsendservice.entities.EmailDetails;

public interface EmailServiceInterface {
	
	String sendSimpleEmail(EmailDetails emailDetails);
	
	String sendEmailWithAttachment(EmailDetails emailDetails);

}
