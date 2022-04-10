package com.topspec.jobfinderv2.config.security;

import com.topspec.jobfinderv2.model.user.Role;

import java.util.List;

import static java.util.Arrays.asList;

public class SecurityURLs {
    final static List<UrlRoles> URLS = asList(
            new UrlRoles("/admin/(.*)", asList(Role.ROLE_ADMIN)),
            new UrlRoles("/hr/(.*)", asList(Role.ROLE_HR)),
            new UrlRoles("/user/(.*)", asList(Role.ROLE_USER))
    );

    private SecurityURLs() {
    }
}
