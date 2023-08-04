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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        String origin = (System.getenv("SITE_URL") == null) ? "http://localhost:3000" : System.getenv("SITE_URL");
        configuration.setAllowedOrigins(Collections.singletonList(origin));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token", "set-cookie"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().cors().disable()
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
