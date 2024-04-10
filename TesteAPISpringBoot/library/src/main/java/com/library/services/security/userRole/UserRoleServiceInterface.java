package com.library.services.security.userRole;

import com.library.dtos.security.UserRoleDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface UserRoleServiceInterface {
    ResponseEntity<Page<UserRoleDto>> getAllUserRoles(int page, int pageSize);
    ResponseEntity<UserRoleDto> getUserRoleById(long id);
    ResponseEntity<UserRoleDto> createUserRole( UserRoleDto userRoleDto);
    ResponseEntity<UserRoleDto> updateUserRole(UserRoleDto userRoleDto, long id);
    ResponseEntity<UserRoleDto> deleteUserRole(long id);
}
