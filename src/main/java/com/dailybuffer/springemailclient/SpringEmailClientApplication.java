package com.dailybuffer.springemailclient;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailClientApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		/*service.sendSimpleEmail("sumitmane81@gmail.com",
				"This is Email Body",
				 "this is email subject");*/

		service.sendEmailWithAttachment("sumitmane81@gmail.com",
				"This is Email Body with Attachment...",
				"This email has attachment",
				"C:\\Users\\Hp\\Downloads\\catimage.jpg");


	}
}
