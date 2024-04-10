package com.library.controllers.security;

import com.library.dtos.security.AuthenteticationDto;
import com.library.dtos.security.RegisterDto;
import com.library.models.security.User;
import com.library.models.security.UserRole;
import com.library.repositories.security.UserRepositoryInterface;
import com.library.services.security.JWTokenService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepositoryInterface userRepository;

    @Autowired
    private JWTokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login( @RequestBody @Validated AuthenteticationDto data){
        UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        Authentication auth = this.authenticationManager.authenticate(loginToken);

        String token = this.tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Validated RegisterDto registerDto){
        if(this.userRepository.findByLogin( registerDto.login()) != null )
            return ResponseEntity.badRequest().body("This login is already registered.");

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
        User newUser = new User( registerDto.login(), encryptedPassword, new UserRole(registerDto.role()));

        this.userRepository.save(newUser);
        return ResponseEntity.ok("Registered successful!");
    }
}
