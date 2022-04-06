package com.topspec.jobfinderv2.service.user;

import com.topspec.jobfinderv2.model.user.Role;
import com.topspec.jobfinderv2.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserSummary {
    public Integer id;
    public String username;
    public String email;
    public List<Role> roles;
    public Boolean active;

    public UserSummary(User user) {
        id = user.getId();
        username = user.getUsername();
        email = user.getEmail();
        roles = new ArrayList<>(user.getRoles());
        active = user.getEnabled();
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Boolean getActive() {
        return active;
    }
}
