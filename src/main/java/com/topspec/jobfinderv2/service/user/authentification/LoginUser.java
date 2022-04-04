package com.topspec.jobfinderv2.service.user.authentification;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.topspec.jobfinderv2.model.user.User;
import com.topspec.jobfinderv2.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class LoginUser {

    private final UserRepository userRepository;

    public LoginUser(UserRepository userRepository) {
        this.userRepository = requireNonNull(userRepository);
    }

    public UserIdAndRolesDto verifyLogin(UserLoginDto userLoginDto) {
        Optional<User> maybeUser = userRepository.findByUsernameOrEmail(userLoginDto.getUsernameOrEmail(), userLoginDto.getUsernameOrEmail());
        if(maybeUser.isPresent() && BCrypt.verifyer().verify(userLoginDto.getPassword().toCharArray(), maybeUser.get().getPassword()).verified)
            return new UserIdAndRolesDto(maybeUser.get().getId(), new HashSet<>(maybeUser.get().getRoles()));
        else throw new NoSuchElementException("Bad Credentials");
    }
}
