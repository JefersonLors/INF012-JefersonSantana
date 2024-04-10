package com.library.services.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.library.models.security.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JWTokenService{
    //@Value("${api.security.token.secret}")
    private String secret ="aloha";
    private final String issuer="library-api";
    private final Algorithm algorithm = Algorithm.HMAC256(secret);

    public String generateToken(User user){
        try{
            return JWT.create()
                    .withIssuer(this.issuer)
                    .withSubject(user.getLogin())
                    .withExpiresAt(this.generateTokenExpireDate())
                    .sign(this.algorithm);
        }catch (Exception ex){
            throw new RuntimeException("Error while generate token: ", ex);
        }
    }
    public String validateToken(String token){
        try{
            return JWT.require(algorithm)
                    .withIssuer(this.issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        }catch( Exception ex ){
            throw new RuntimeException("Erro while validate token: ", ex );
        }
    }

    private Instant generateTokenExpireDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
