package com.emailSenderMS.emailMs.dtos;

import com.emailSenderMS.emailMs.entities.Email;
import com.emailSenderMS.emailMs.entities.MailSendingStatus;

import java.time.LocalDateTime;

public record EmailDto(Long id, String mailFrom, String mailTo,
                       String mailSubject, String mailText,
                       LocalDateTime mailSendDateTime) {

    public EmailDto(Email email){
        this(email.getId(), email.getMailFrom(), email.getMailTo(), email.getMailSubject(),
                email.getMailText(), email.getMailSendDateTime());
    }


}
