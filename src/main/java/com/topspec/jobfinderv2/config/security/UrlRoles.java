package com.topspec.jobfinderv2.config.security;

import com.topspec.jobfinderv2.model.user.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UrlRoles {
    String url;
    Set<Role> roles;

    UrlRoles(String url, List<Role> roles) {
        this.url = url;
        this.roles = new HashSet<>(roles);
    }
}
