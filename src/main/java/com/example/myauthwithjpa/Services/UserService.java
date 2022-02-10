package com.example.myauthwithjpa.Services;

import com.example.myauthwithjpa.Entity.User;
import com.example.myauthwithjpa.Persistence.AuthorityRepository;
import com.example.myauthwithjpa.Persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;


    @Transactional
    public void add(User user) {
        if (user.getEncryptionType() == null) {
            user.setEncryptionType("BCrypt");
        }

        user.setAuthorities(authorityRepository.saveAll(user.getAuthorities()));
        user.getAuthorities().forEach(
                e -> {

                    if (e.getUsers() == null) {
                        e.setUsers(new ArrayList<>());
                    }
                    e.getUsers().add(user);

                }
        );
        userRepository.save(user);
    }

    public Optional<User> findByName(String username) {
        return userRepository.findById(username);
    }
}
