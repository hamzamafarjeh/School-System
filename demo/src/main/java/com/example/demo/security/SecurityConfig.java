package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // نوقف CSRF عشان REST API
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public/**").permitAll() // أي API داخل public مسموح للجميع
                        .anyRequest().authenticated() // باقي الـ APIs بدها login
                )
                .httpBasic(basic -> {}) // نستخدم basic authentication
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // REST API → stateless

        return http.build();
    }
}

