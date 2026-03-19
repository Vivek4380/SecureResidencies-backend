package com.example.hostel.entry_exit_flow.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EntryExitMailConfig {
    @Bean(name = "mailtrapMailSender")
    public JavaMailSender mailtrapMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("sandbox.smtp.mailtrap.io");
        mailSender.setPort(2525);
        mailSender.setUsername("df29e82d383d0b");
        mailSender.setPassword("69b1a5b5861579");
        mailSender.setProtocol("smtp");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        return mailSender;
    }

    @Bean(name = "fakeSmtpMailSender")
    @Primary
    public JavaMailSender fakeSmtpMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("localhost");
        mailSender.setPort(1025);
        mailSender.setUsername("hello");
        mailSender.setPassword("hello");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.connectiontimeout", 5000);
        props.put("mail.smtp.timeout", 3000);
        props.put("mail.smtp.writetimeout", 5000);
        return mailSender;
    }
} 