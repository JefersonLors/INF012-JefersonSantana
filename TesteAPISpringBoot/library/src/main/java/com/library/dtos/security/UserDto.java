package com.library.dtos.security;

import com.library.models.security.User;
import com.library.models.security.UserRole;

public record UserDto(Long id, String name, String login, String password, UserRole role) {
    public UserDto(User user){
        this(user.getId(), user.getName(), user.getLogin(), user.getPassword(), user.getRole());
    }
}
