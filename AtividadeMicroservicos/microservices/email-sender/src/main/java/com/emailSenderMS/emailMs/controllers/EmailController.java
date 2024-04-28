package com.emailSenderMS.emailMs.controllers;

import com.emailSenderMS.emailMs.dtos.EmailDto;
import com.emailSenderMS.emailMs.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<EmailDto> sendEmail(@RequestBody EmailDto emailDto){
        return this.emailService.sendEmail(emailDto);
    }
}
