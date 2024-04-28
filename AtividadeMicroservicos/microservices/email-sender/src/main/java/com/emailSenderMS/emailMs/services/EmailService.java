package com.emailSenderMS.emailMs.services;

import com.emailSenderMS.emailMs.dtos.EmailDto;
import com.emailSenderMS.emailMs.entities.Email;
import com.emailSenderMS.emailMs.entities.MailSendingStatus;
import com.emailSenderMS.emailMs.repositories.EmailRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    @Autowired
    private EmailRespository emailRespository;

    @Autowired
    private JavaMailSender mailSender;

    public ResponseEntity<EmailDto> sendEmail(EmailDto emailDto){
        Email email = new Email(emailDto);
        email.setMailSendDateTime(LocalDateTime.now());

        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(emailDto.mailFrom());
            simpleMailMessage.setTo(emailDto.mailTo());
            simpleMailMessage.setSubject(emailDto.mailSubject());
            simpleMailMessage.setText(emailDto.mailText());

            this.mailSender.send(simpleMailMessage);
            email.setMailSendingStatus(MailSendingStatus.SENT);
            this.emailRespository.save(email);

            return ResponseEntity.ok(new EmailDto(email));
        }catch (Exception ex){
            email.setMailSendingStatus(MailSendingStatus.ERROR);
            this.emailRespository.save(email);
            System.out.println("<<< EXCEPTION >>>: " + ex.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
