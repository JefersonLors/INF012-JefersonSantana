package com.library.dtos.security;

import com.library.models.security.User;
import com.library.models.security.UserRole;

public record UserRoleDto(Long id, String name, String description) {
    public UserRoleDto(UserRole userRole){
        this(userRole.getId(), userRole.getName(), userRole.getDescription());
    }

}
