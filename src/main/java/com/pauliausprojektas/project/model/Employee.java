package com.pauliausprojektas.project.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Data @NoArgsConstructor
@Entity
public class Employee implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, updatable = true)
    private String lastName;
    @Column(nullable = false, updatable = true)
    private String password;
    @Column(nullable = false,updatable = true)
    private String email;
    @Column(nullable = false,updatable = true)
    private String jobTitle;

    public Employee(String username, String name, String lastName, String password, String email, String jobTitle) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.jobTitle = jobTitle;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
