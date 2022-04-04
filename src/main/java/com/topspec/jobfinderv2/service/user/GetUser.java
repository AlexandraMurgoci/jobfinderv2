package com.topspec.jobfinderv2.service.user;

import com.topspec.jobfinderv2.model.user.User;
import com.topspec.jobfinderv2.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

@Service
@Transactional
public class GetUser {

    private final UserRepository userRepository;

    public GetUser(UserRepository userRepository) {
        this.userRepository = requireNonNull(userRepository);
    }

    public Optional<User> byEmail(String emal) {
        return userRepository.findByEmail(emal);
    }
}
