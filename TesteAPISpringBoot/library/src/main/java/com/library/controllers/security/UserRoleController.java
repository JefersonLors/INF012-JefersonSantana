package com.library.controllers.security;

import com.library.dtos.security.UserRoleDto;
import com.library.services.security.userRole.UserRoleServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-roles")
public class UserRoleController {
    @Autowired
    private UserRoleServiceInterface userRoleService;

    @GetMapping
    public ResponseEntity<Page<UserRoleDto>> getAllUserRoles(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "1000") int pageSize){
        return userRoleService.getAllUserRoles(page, pageSize);
    }
    @GetMapping("/id")
    public ResponseEntity<UserRoleDto> getUserRoleById(@RequestParam long id){
        return userRoleService.getUserRoleById(id);
    }
    @PostMapping
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<UserRoleDto> createUserRole(@RequestBody UserRoleDto userRoleDto){
        return userRoleService.createUserRole(userRoleDto);
    }

    @PutMapping("/{id}")
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<UserRoleDto> updateUserRole(@RequestBody UserRoleDto userRoleDto,
                                                      @PathVariable long id){
        return userRoleService.updateUserRole(userRoleDto, id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ADMIN")
    public ResponseEntity<UserRoleDto> deleteUserRole(@PathVariable long id){
        return userRoleService.deleteUserRole(id);
    }
}
