package com.topspec.jobfinderv2.config.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.topspec.jobfinderv2.model.user.Role;
import com.topspec.jobfinderv2.model.user.User;
import com.topspec.jobfinderv2.service.user.GetUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class SecurityHttpInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = Logger.getLogger(SecurityHttpInterceptor.class.getName());
    private static final String USER_USERNAME_HEADER = "user-username";
    private static final String USER_PASSWORD_HEADER = "user-password";

    @Autowired
    private GetUser getUser;


    @Override
    public boolean preHandle(HttpServletRequest requestServlet, HttpServletResponse responseServlet, Object handler) throws Exception
    {
        String url = requestServlet.getRequestURI();
        LOGGER.info(url);

        Set<Role> roles = getRequiredRolesForUrl(url);
        List<String> headers = Collections.list(requestServlet.getHeaderNames());
        if(roles.isEmpty()) {
            return true;
        }

        if(!headers.contains(USER_USERNAME_HEADER) || !headers.contains((USER_PASSWORD_HEADER))) {
            responseServlet.setStatus(HttpStatus.FORBIDDEN.value());
            return false;
        }

        Optional<User> maybeUser = getUser.byEmail(requestServlet.getHeader(USER_USERNAME_HEADER));

        if(maybeUser.isEmpty() || !BCrypt.verifyer().verify(requestServlet.getHeader(USER_PASSWORD_HEADER).toCharArray(), maybeUser.get().getPassword()).verified || !maybeUser.get().getEnabled()) {
            responseServlet.setStatus(HttpStatus.FORBIDDEN.value());
            return false;
        }

        if(!maybeUser.get().getRoles().containsAll(roles)) {
            responseServlet.setStatus(HttpStatus.FORBIDDEN.value());
            return false;
        }

        return true;
    }

    private Set<Role> getRequiredRolesForUrl(String url) {
        for(UrlRoles urlRoles : SecurityURLs.URLS) {
            if(url.matches(urlRoles.url)) return urlRoles.roles;
        }
        return Collections.emptySet();
    }
}
