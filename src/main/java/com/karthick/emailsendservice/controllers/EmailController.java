package com.karthick.emailsendservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.karthick.emailsendservice.entities.EmailDetails;
import com.karthick.emailsendservice.services.EmailService;



@RestController
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/sendMail")
	@ResponseBody
	public String sendEmail(@RequestBody EmailDetails emailDetails) {
		
		return emailService.sendEmail(emailDetails);
	}

}
