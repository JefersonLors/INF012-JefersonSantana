package com.library.repositories.security;

import com.library.models.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepositoryInterface extends JpaRepository<User, Long> {
    UserDetails findByLogin(String login);
}
