package com.topspec.jobfinderv2.service.user;

import com.topspec.jobfinderv2.model.user.Role;
import com.topspec.jobfinderv2.model.user.User;
import com.topspec.jobfinderv2.repository.UserRepository;
import com.topspec.jobfinderv2.service.user.authentification.LoginUser;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateUserTest {
    private final UserRepository userRepository = mock(UserRepository.class);

    private final CreateUser sut = new CreateUser(userRepository);

    @Test
    public void should_create_user_okay(){
        when(userRepository.save(any())).thenReturn(new User(1,"mail1","user1","dwdgfgxaaawerre",true, Collections.singletonList(Role.ROLE_USER)));

        User result = sut.create(new CreateUserDto("mail1","user1","pass1", Collections.singletonList(Role.ROLE_USER)));

        assertThat(result).isNotNull()
                        .hasFieldOrPropertyWithValue("id",1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_mail_is_empty(){
        sut.create(new CreateUserDto(null,"user1","pass1", Collections.singletonList(Role.ROLE_USER)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_username_is_empty(){
        sut.create(new CreateUserDto("mail1",null,"pass1", Collections.singletonList(Role.ROLE_USER)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_password_is_empty(){
        sut.create(new CreateUserDto("mail1","user1",null, Collections.singletonList(Role.ROLE_USER)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_role_is_empty(){
        sut.create(new CreateUserDto("mail1","user1","pass1", Collections.emptyList()));
    }
}
