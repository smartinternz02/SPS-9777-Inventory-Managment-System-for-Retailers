package com.futuretech.inventorymanagementapp;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	@Autowired
	private JavaMailSender sender;
	public void sendEmail(String to, String body, String topic) throws Exception{
		System.out.println("Sending Mail");
		System.out.println(to);
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		
		helper.setTo(to);
		helper.setSubject(topic);
		helper.setText(body);
		
		System.out.println("Mail is ready");
		sender.send(message);
		System.out.println("Mail sent");
	}
	
}
