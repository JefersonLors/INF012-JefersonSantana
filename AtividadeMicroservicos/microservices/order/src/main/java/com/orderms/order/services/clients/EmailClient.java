package com.orderms.order.services.clients;

import com.orderms.order.dtos.EmailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("email-sender")
public interface EmailClient {
    @RequestMapping(method = RequestMethod.POST, value= "/email")
    public ResponseEntity<EmailDto> sendEmail(@RequestBody EmailDto emailDto);
}
