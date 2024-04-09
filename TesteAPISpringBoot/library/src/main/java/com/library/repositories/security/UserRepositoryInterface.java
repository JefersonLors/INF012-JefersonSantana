package com.library.repositories.security;

import com.library.models.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository<User, Long> {
}
