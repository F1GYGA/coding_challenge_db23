package com.db.grad.javaapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                                authorize
                                        .requestMatchers(new AntPathRequestMatcher("/users/**")).authenticated()
                                        .requestMatchers(new AntPathRequestMatcher("/books/**")).authenticated()
                                        .requestMatchers(new AntPathRequestMatcher("/trades/**")).authenticated()
                                        .requestMatchers(new AntPathRequestMatcher("/counterparties/**")).authenticated()
                                        .requestMatchers(new AntPathRequestMatcher("/bonds/**")).authenticated()
                                        .anyRequest().permitAll()
                        //authorize.requestMatchers(new AntPathRequestMatcher("/status")).permitAll()
                        //        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                        //       .anyRequest().authenticated()
                        //TODO change here to make other endpoints require authentication after creating frontend

                );

        return http.build();
    }
}
