package com.topspec.jobfinderv2.service.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.topspec.jobfinderv2.model.user.User;
import com.topspec.jobfinderv2.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class CreateUser {
    private final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = requireNonNull(userRepository);
    }

    public User create(CreateUserDto createUserDto){
        User user = new User(createUserDto.getEmail(), createUserDto.getUsername(), BCrypt.withDefaults().hashToString(12, createUserDto.getPassword().toCharArray()));
        return userRepository.save(user);

    }
}
