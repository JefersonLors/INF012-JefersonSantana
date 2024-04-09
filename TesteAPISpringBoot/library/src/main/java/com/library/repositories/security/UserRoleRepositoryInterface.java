package com.library.repositories.security;

import com.library.models.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepositoryInterface extends JpaRepository<UserRole, Long> {
}
