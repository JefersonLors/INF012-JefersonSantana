package com.loja.loja_ms.dtos;

import java.time.LocalDateTime;

public record EmailDto(long id, String mailFrom, String mailTo, String mailSubject,
                       String mailText, LocalDateTime mailDthSend, EmailStatusDto mailStatus) {

}
