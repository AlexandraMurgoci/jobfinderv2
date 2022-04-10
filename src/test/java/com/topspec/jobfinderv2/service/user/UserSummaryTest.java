package com.topspec.jobfinderv2.service.user;

import com.topspec.jobfinderv2.model.user.Role;
import com.topspec.jobfinderv2.model.user.User;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class UserSummaryTest {

    private static final Integer USER_ID = 1;
    private static final String USER_EMAIL = "some.mail@mail.com";
    private static final String USER_USERNAME = "someUsername";
    private static final String USER_PASSWORD = "somePasswordHash";
    private static final boolean USER_ENABLED = true;
    private static final List<Role> USER_ROLES = singletonList(Role.ROLE_ADMIN);

    @Test
    public void should_construct_from_user_ok() {
        UserSummary userSummary = new UserSummary(new User(
                USER_ID, USER_EMAIL, USER_USERNAME, USER_PASSWORD, USER_ENABLED, USER_ROLES
        ));

        assertThat(userSummary)
                .hasFieldOrPropertyWithValue("id", USER_ID)
                .hasFieldOrPropertyWithValue("email", USER_EMAIL)
                .hasFieldOrPropertyWithValue("username", USER_USERNAME)
                .hasFieldOrPropertyWithValue("active", USER_ENABLED)
                .hasFieldOrPropertyWithValue("roles", USER_ROLES);

    }
}
