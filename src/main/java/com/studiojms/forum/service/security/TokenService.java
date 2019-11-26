package com.studiojms.forum.service.security;

import com.studiojms.forum.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        final User user = (User) authentication.getPrincipal();

        final Date generatedAt = new Date();
        final Date expirationDate = new Date(generatedAt.getTime() + Long.parseLong(expiration));


        return Jwts.builder()
                .setIssuer("Forum Rest API")
                .setSubject(user.getId().toString())
                .setIssuedAt(generatedAt)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValid(String token) {
        boolean valid = false;
        try {
            final Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            valid = true;
        } catch (Exception e) {
            valid = false;
        }

        return valid;
    }

    public Long getUserId(String token) {
        final Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(body.getSubject());
    }
}
