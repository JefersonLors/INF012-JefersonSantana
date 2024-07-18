package com.orderms.order.dtos;

import java.time.LocalDateTime;

public record EmailDto(Long id, String mailFrom, String mailTo,
                       String mailSubject, String mailText,
                       LocalDateTime mailSendDateTime) {

}
