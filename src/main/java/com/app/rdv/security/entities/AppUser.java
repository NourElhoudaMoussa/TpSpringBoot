package com.app.rdv.security.entities;

import com.app.rdv.security.entities.AppRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String email;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> role;

}
