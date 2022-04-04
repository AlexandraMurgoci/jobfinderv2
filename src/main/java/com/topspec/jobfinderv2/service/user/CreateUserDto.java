package com.topspec.jobfinderv2.service.user;

import com.topspec.jobfinderv2.model.user.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateUserDto {
    private String email;
    private String username;
    private String password;
    private List<Role> roles;

    public CreateUserDto() {
    }

    public CreateUserDto(String email, String username, String password, List<Role> roles) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
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

    public List<Role> getRoles() {
        return roles;
    }
}
