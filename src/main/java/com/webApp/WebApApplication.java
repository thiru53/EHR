package com.webApp;

import com.webApp.service.AppointmentService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class WebApApplication {

	@Autowired
	private AppointmentService service;

	public static void main(String[] args) {
		SpringApplication.run(WebApApplication.class, args);
		System.out.println("Application");
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail( ) throws MessagingException {
		//emailmsg.sendConfirmationNotification()

	}

}
