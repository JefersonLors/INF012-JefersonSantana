package com.library.services.security.user;

import com.library.dtos.security.UserDto;
import com.library.models.security.User;
import com.library.repositories.security.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    private UserRepositoryInterface userRepository;

    @Override
    public ResponseEntity<Page<UserDto>> getAllUsers(int page, int pageSize) {
        Pageable pageContentSize = PageRequest.of( page, pageSize);
        Page<UserDto> userDtoPage = this.userRepository.findAll(pageContentSize).map(UserDto::new);

        return new ResponseEntity<>(userDtoPage, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> getUserById(long id) {
        Optional<User> userEntityOptional = this.userRepository.findById(id);

        return userEntityOptional.map(user -> ResponseEntity.ok(new UserDto(user)))
                                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        User user = this.userRepository.save(new User(userDto));

        return new ResponseEntity<>(new UserDto(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto userDto, long id) {
        if(this.userRepository.existsById(id)){
            User user =  new User(userDto);
            user.setId(id);
            user = this.userRepository.save(user);
            return ResponseEntity.ok(new UserDto(user));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(long id) {
        if(this.userRepository.existsById(id)){
           this.userRepository.deleteById(id);
           return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
