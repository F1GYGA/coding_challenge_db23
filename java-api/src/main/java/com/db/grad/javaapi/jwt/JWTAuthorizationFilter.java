package com.db.grad.javaapi.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.db.grad.javaapi.config.JWTConfig;
import com.db.grad.javaapi.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final String AUTH_COOKIE = "AUTH_COOKIE";

    private JWTConfig jwtConfig;

    private CustomUserDetailsService userService;

    public JWTAuthorizationFilter(@Autowired AuthenticationManager authenticationManager,
                                  @Autowired JWTConfig jwtConfig,
                                  @Autowired CustomUserDetailsService userService
                                  ) {
        super(authenticationManager);
        this.jwtConfig = jwtConfig;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie cookie = WebUtils.getCookie(request, AUTH_COOKIE);
        if (cookie == null || cookie.getValue() == null || cookie.getValue().trim().isEmpty()) {
            // If there is no cookie, the user is not authenticated. Continue the filter chain.
            chain.doFilter(request, response);
            return;
        }
        String token = cookie.getValue();
        String username = getAuthenticationToken(token);
        String savedToken = null;
        if (username != null) {
            try {
                savedToken = userService.findByName(username).getToken();
            } catch (UsernameNotFoundException ignored) {
            }
        }
        if (Objects.equals(token, savedToken) && savedToken != null) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>()));
        }
        chain.doFilter(request, response);
    }

    private String getAuthenticationToken(String token) {
        // Parse and verify the provided token.
        return JWT.require(Algorithm.HMAC512((System.getenv("JWT_SECRET") == null)
                        ? "default_JWT_secret"
                        : System.getenv("JWT_SECRET")))
                .build()
                .verify(token)
                .getSubject();
    }
}