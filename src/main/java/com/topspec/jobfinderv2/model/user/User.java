package com.topspec.jobfinderv2.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@SequenceGenerator(name = "sequence_users", allocationSize = 1)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_users")
    @Column(name = "user_id")
    private Integer id;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private Boolean enabled;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Collection<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public User(Integer id, String email, String username, String password, Boolean enabled, Collection<Role> roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Collection<Role> getRoles() {
        return roles;
    }
}
