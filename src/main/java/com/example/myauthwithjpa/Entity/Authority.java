package com.example.myauthwithjpa.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "authority")
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

public class Authority {
    @Id
    @NonNull
    private String authority;

    @ManyToMany()
    @JoinTable(
            name = "authority_users",
            joinColumns = @JoinColumn(name = "name"),
            inverseJoinColumns = @JoinColumn(name = "authority")
    )
    @JsonIgnore
    private List<User> users;
}
