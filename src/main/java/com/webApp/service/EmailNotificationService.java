package com.webApp.service;

//
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.stereotype.Service;
//
// @Service
// public class EmailNotificationService {
// @Autowired
// private JavaMailSender mailSender;
//
// @Value("${spring.mail.host}")
// private String host;
//
// @Value("${spring.mail.port}")
// private int port;
//
// @Value("${spring.mail.username}")
// private String username;
//
// @Value("${spring.mail.password}")
// private String password;
//
// public void sendConfirmationNotification(String recipient, String subject,
// String message) {
// SimpleMailMessage msg =new SimpleMailMessage();
//
//
//
// msg.setFrom("199abhilashakumari@gmail.com");
// msg.setTo(recipient);
// msg.setSubject(subject);
// msg.setText(message);
//
//
// mailSender.send(msg);
// System.out.println("Message sent Succssfully");
// }
//
// }
