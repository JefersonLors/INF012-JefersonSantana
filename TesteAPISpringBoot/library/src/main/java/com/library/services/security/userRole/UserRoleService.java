package com.library.services.security.userRole;

import com.library.dtos.security.UserRoleDto;
import com.library.models.security.UserRole;
import com.library.repositories.security.UserRoleRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleService implements UserRoleServiceInterface{
    @Autowired
    private UserRoleRepositoryInterface userRoleRepository;

    @Override
    public ResponseEntity<Page<UserRoleDto>> getAllUserRoles(int page, int pageSize) {
        Pageable contentPageSize = PageRequest.of(page, pageSize);

        Page<UserRoleDto> userRolePage = this.userRoleRepository.findAll(contentPageSize)
                                                                .map(UserRoleDto::new);
        return ResponseEntity.ok(userRolePage);
    }

    @Override
    public ResponseEntity<UserRoleDto> getUserRoleById(long id) {
        Optional<UserRole> userRole = this.userRoleRepository.findById(id);

        return userRole.map(userRoleEP -> ResponseEntity.ok(new UserRoleDto(userRoleEP)))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<UserRoleDto> createUserRole(UserRoleDto userRoleDto) {
        UserRole userRole = this.userRoleRepository.save(new UserRole(userRoleDto));

        return ResponseEntity.ok(new UserRoleDto(userRole));
    }

    @Override
    public ResponseEntity<UserRoleDto> updateUserRole(UserRoleDto userRoleDto, long id) {
        if( this.userRoleRepository.existsById(id) ){
            UserRole userRole = new UserRole(userRoleDto);
            userRole.setId(id);
            userRole = this.userRoleRepository.save(userRole);
            return ResponseEntity.ok(new UserRoleDto(userRole));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<UserRoleDto> deleteUserRole(long id) {
        if( this.userRoleRepository.existsById(id)){
            this.userRoleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
