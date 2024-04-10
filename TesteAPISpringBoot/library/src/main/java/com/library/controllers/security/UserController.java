package com.library.controllers.security;

import com.library.dtos.security.UserDto;
import com.library.services.security.user.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceInterface userService;

    @GetMapping
    public ResponseEntity<Page<UserDto>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "1000") int pageSize){
        return userService.getAllUsers(page, pageSize);
    }

    @GetMapping("/id")
    public ResponseEntity<UserDto> getUserById(@RequestParam long id){
        return userService.getUserById(id);
    }

//    @PostMapping
//    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
//        return userService.createUser(userDto);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
//                                              @PathVariable long id){
//        return userService.updateUser(userDto, id);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }
}
