package com.topspec.jobfinderv2.service.user.authentification;

import com.topspec.jobfinderv2.model.user.Role;

import java.util.HashSet;
import java.util.Set;

public class UserIdAndRolesDto {
    private Integer userId;
    private Set<Role> roles;

    public UserIdAndRolesDto() {
        userId = 0;
        roles = new HashSet<>();
    }

    public UserIdAndRolesDto(Integer userId, Set<Role> roles) {
        this.userId = userId;
        this.roles = roles;
    }

    public Integer getUserId() {
        return userId;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
