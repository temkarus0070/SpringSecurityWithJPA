package com.example.myauthwithjpa.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {
    @Bean
    public UserDetailsService userDetailsManager(JPAUserDetailsManager jpaUserDetailsManager) {
        jpaUserDetailsManager.createUser(User
                .withUsername("artyom")
                .password("1234")
                .authorities("user")
                .build());
        return jpaUserDetailsManager;
    }


    @Bean
    public DelegatingPasswordEncoder delegatingPasswordEncoder() {
        Map<String, PasswordEncoder> map = new HashMap<>();
        map.put("BCrypt", new BCryptPasswordEncoder());
        map.put("SCrypt", new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder("BCrypt", map);
    }
}
