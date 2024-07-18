package com.emailSenderMS.emailMs.entities;

import com.emailSenderMS.emailMs.dtos.EmailDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="emails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mailFrom;
    private String mailTo;
    private String mailSubject;
    private String mailText;
    private LocalDateTime mailSendDateTime;

    @Enumerated(EnumType.STRING)
    private MailSendingStatus mailSendingStatus = MailSendingStatus.SENT;

    public Email(EmailDto emailDto){
        this.id = emailDto.id();
        this.mailFrom = emailDto.mailFrom();
        this.mailTo = emailDto.mailTo();
        this.mailSubject = emailDto.mailSubject();
        this.mailText = emailDto.mailText();
        this.mailSendDateTime = emailDto.mailSendDateTime();
    }

}
