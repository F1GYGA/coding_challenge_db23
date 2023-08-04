package com.db.grad.javaapi.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.db.grad.javaapi.config.JWTConfig;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final String AUTH_COOKIE = "AUTH_COOKIE";

    @Autowired
    private JWTConfig jwtConfig;

    @Autowired
    CustomUserDetailsService userService;

    public JWTAuthenticationFilter(@Autowired AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String username = ((org.springframework.security.core.userdetails.User) authResult.getPrincipal()).getUsername();
        User user = userService.findByName(username);
        if (user == null) {
            throw new IllegalArgumentException("authResult must be an instance of User");
        }
        String token = JWT.create().withSubject(user.getUserName())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConfig.expirationTime))
                .sign(Algorithm.HMAC512(jwtConfig.secret));
        userService.updateToken(user.getUserName(), token);
        Cookie cookie = new Cookie(AUTH_COOKIE, token);
        cookie.setSecure(true);
        response.addCookie(cookie);
        String header = response.getHeader(HttpHeaders.SET_COOKIE);
        response.setHeader(HttpHeaders.SET_COOKIE, String.format("%s; %s", header, "SameSite=None"));
        chain.doFilter(request, response);
    }
}
