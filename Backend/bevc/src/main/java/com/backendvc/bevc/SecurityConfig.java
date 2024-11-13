package com.backendvc.bevc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for development; enable it in production with proper setup
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/users/register").permitAll() // Allow access to signup
                .anyRequest().authenticated() // Other endpoints require authentication
            );
        return http.build();
    }
}