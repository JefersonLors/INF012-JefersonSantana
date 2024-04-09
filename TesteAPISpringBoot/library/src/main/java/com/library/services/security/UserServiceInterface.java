package com.library.services.security;

import com.library.dtos.security.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface UserServiceInterface {
    ResponseEntity<Page<UserDto>> getAllUsers(int page, int pageSize);
    ResponseEntity<UserDto> getUserById(long id);
    ResponseEntity<UserDto> createUser(UserDto userDto);
    ResponseEntity<UserDto> updateUser(UserDto userDto, long id);
    ResponseEntity<UserDto> deleteUser(long id);
}
