package com.topspec.jobfinderv2.service.user.authentication;

import com.topspec.jobfinderv2.model.user.Role;
import com.topspec.jobfinderv2.model.user.User;
import com.topspec.jobfinderv2.repository.UserRepository;
import com.topspec.jobfinderv2.service.user.authentification.LoginUser;
import com.topspec.jobfinderv2.service.user.authentification.UserIdAndRolesDto;
import com.topspec.jobfinderv2.service.user.authentification.UserLoginDto;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginUserTest {

    private final UserRepository userRepository = mock(UserRepository.class);

    private final LoginUser sut = new LoginUser(userRepository);

    private static final String ADMIN_EMAIL = "alexa.murgoci@gmail.com";
    private static final String ADMIN_PASSWORD = "password";

    @Test
    public void should_login_first_admin() {
        when(userRepository.findByUsernameOrEmail(any(), any())).thenReturn(Optional.of(
                firstAdminUser()
        ));

        UserIdAndRolesDto result = sut.verifyLogin(new UserLoginDto(ADMIN_EMAIL, ADMIN_PASSWORD));

        assertThat(result.getRoles())
                .containsExactly(Role.ROLE_ADMIN);
    }

    @Test(expected = NoSuchElementException.class)
    public void should_throw_exception_if_user_not_found() {
        when(userRepository.findByUsernameOrEmail(any(), any())).thenReturn(Optional.empty());

        sut.verifyLogin(new UserLoginDto(ADMIN_EMAIL, ADMIN_PASSWORD));
    }

    @Test(expected = NoSuchElementException.class)
    public void should_throw_exception_if_passwords_do_not_match() {
        when(userRepository.findByUsernameOrEmail(any(), any())).thenReturn(Optional.empty());

        sut.verifyLogin(new UserLoginDto(ADMIN_EMAIL, "badPassword"));
    }

    private User firstAdminUser() {
        return new User(1, ADMIN_EMAIL, "AlexaAdmin",
                "$2a$12$n8rEkxdS4UNkexHCCLvQZuQVPh70PnFooS1vF0l/2XYFHHAqfjMwi",
                true, singletonList(Role.ROLE_ADMIN));
    }
}
