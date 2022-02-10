package com.example.myauthwithjpa.Security;

import com.example.myauthwithjpa.Entity.Authority;
import com.example.myauthwithjpa.Entity.User;
import com.example.myauthwithjpa.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JPAUserDetailsManager implements UserDetailsManager {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserDetails user) {
        userService.add(new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), "BCrypt", Stream.of(user.getAuthorities()).flatMap(Collection::stream)
                .map(e -> new Authority(e.getAuthority()))
                .collect(Collectors.toList())));
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return userService.findByName(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new com.example.myauthwithjpa.Security.Entity.UserDetails(userService.findByName(username).orElseThrow(() -> new AuthenticationCredentialsNotFoundException("NOT CORRECT USERNAME OR PASS")));
    }
}
