package com.studiojms.forum.filter;

import com.studiojms.forum.domain.User;
import com.studiojms.forum.domain.security.AuthenticationMethodEnum;
import com.studiojms.forum.service.UserService;
import com.studiojms.forum.service.security.TokenService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private UserService userService;

    public TokenAuthenticationFilter(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getTokenFromRequest(request);

        final boolean valid = tokenService.isValid(token);

        if (valid) {
            authenticateRequest(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticateRequest(String token) {
        Long userId = tokenService.getUserId(token);
        final User user = userService.findById(userId);
        final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

    }

    private String getTokenFromRequest(HttpServletRequest request) {
        final String token = request.getHeader("Authorization");

        final String authenticationMethod = AuthenticationMethodEnum.BEARER.getValue();

        String ret;

        if (token == null || token.isEmpty() || !token.startsWith(authenticationMethod + " ")) {
            ret = null;
        } else {
            ret = token.substring(authenticationMethod.length() + 1);
        }

        return ret;
    }
}
