package com.db.grad.javaapi.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {
    public String secret = (System.getenv("JWT_SECRET") == null)
            ? "default_JWT_secret"
            : System.getenv("JWT_SECRET");

    public int expirationTime = (System.getenv("JWT_EXPIRES") == null)
            ? 1209600000
            : Integer.parseInt(System.getenv("JWT_EXPIRES"));
}
