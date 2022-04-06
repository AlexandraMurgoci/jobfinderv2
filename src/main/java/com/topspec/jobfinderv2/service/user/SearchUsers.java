package com.topspec.jobfinderv2.service.user;

import com.topspec.jobfinderv2.model.user.User;
import com.topspec.jobfinderv2.repository.UserRepository;
import com.topspec.jobfinderv2.service.CustomPageImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class SearchUsers {

    private final UserRepository userRepository;

    public SearchUsers(UserRepository userRepository) {
        this.userRepository = requireNonNull(userRepository);
    }

    public CustomPageImpl<UserSummary> findUsersByIdOrUsername(String searchParameter, Integer page) {
        Pageable pageRequest = PageRequest.of(page, 10, Sort.by("id"));
        Page<User> users = searchParameter!= null ?
                userRepository.findAllByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(searchParameter, searchParameter, pageRequest) :
                userRepository.findAll(pageRequest);
        return new CustomPageImpl<>(users.stream()
                .map(UserSummary::new)
                .collect(toList()),
                users.getTotalPages(), users.getTotalElements());
    }

}
