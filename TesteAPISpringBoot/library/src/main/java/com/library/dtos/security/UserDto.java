package com.library.dtos.security;

import com.library.models.security.User;

public record UserDto(Long id, String name, String login, String password, UserRoleDto role) {
    public UserDto(User user){
        this(user.getId(), user.getName(), user.getLogin(), user.getPassword(), new UserRoleDto(user.getRole()));
    }
}
