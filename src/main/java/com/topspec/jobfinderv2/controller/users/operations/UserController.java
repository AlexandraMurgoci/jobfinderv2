package com.topspec.jobfinderv2.controller.users.operations;

import com.topspec.jobfinderv2.service.user.CreateUser;
import com.topspec.jobfinderv2.service.user.CreateUserDto;
import com.topspec.jobfinderv2.service.user.authentification.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.requireNonNull;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {


    private final CreateUser createUser;

    public UserController(CreateUser createUser) {
        this.createUser = requireNonNull(createUser);
    }

    @PostMapping("/user")
    public ResponseEntity createUser (@RequestBody CreateUserDto createUserDto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(createUser.create(createUserDto));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
