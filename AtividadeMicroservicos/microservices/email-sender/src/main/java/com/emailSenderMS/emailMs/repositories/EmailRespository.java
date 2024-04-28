package com.emailSenderMS.emailMs.repositories;

import com.emailSenderMS.emailMs.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRespository extends JpaRepository<Email, Long> {
}
