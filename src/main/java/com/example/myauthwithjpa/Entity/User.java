package com.example.myauthwithjpa.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "name")
    private String username;


    @Column(name = "password")
    private String password;


    @Column(name = "encryption_type")
    private String encryptionType;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Authority> authorities;


}
