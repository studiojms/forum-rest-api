package com.studiojms.forum.controller;

import com.studiojms.forum.domain.security.AuthenticationMethodEnum;
import com.studiojms.forum.service.security.TokenService;
import com.studiojms.forum.to.LoginTO;
import com.studiojms.forum.to.TokenTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenTO> authenticate(@RequestBody @Valid LoginTO login) {
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

        try {
            final Authentication authentication = authenticationManager.authenticate(authenticationToken);
            final String token = tokenService.generateToken(authentication);

            return ResponseEntity.ok(new TokenTO(token, AuthenticationMethodEnum.BEARER));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
