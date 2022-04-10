package com.topspec.jobfinderv2.repository;

import com.topspec.jobfinderv2.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);

    Page<User> findAllByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(String searchParam1, String searchParam2, Pageable pageable);
}
