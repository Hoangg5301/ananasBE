package com.example.ananasstore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SercurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests(requests -> requests.anyRequest().authenticated());
                .anyRequest().authenticated();

        httpSecurity.csrf(httpSecurityCsrfConfigurer -> {httpSecurityCsrfConfigurer.disable();});
        return httpSecurity.build();
    }
}
