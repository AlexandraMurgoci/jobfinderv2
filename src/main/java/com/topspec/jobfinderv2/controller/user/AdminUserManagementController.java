package com.topspec.jobfinderv2.controller.user;

import com.topspec.jobfinderv2.model.user.User;
import com.topspec.jobfinderv2.service.user.CreateUser;
import com.topspec.jobfinderv2.service.user.CreateUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.requireNonNull;

@RestController
@CrossOrigin("http://localhost:4200")
public class AdminUserManagementController {


    private final CreateUser createUser;

    public AdminUserManagementController(CreateUser createUser) {
        this.createUser = requireNonNull(createUser);
    }


    @PostMapping("/admin/user/create")
    public ResponseEntity<User> createUser (@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.status(HttpStatus.OK).body(createUser.create(createUserDto));
    }
}
