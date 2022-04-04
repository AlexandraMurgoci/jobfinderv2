package com.topspec.jobfinderv2.controller.user.authentication;

import com.topspec.jobfinderv2.service.user.authentification.LoginUser;
import com.topspec.jobfinderv2.service.user.authentification.UserIdAndRolesDto;
import com.topspec.jobfinderv2.service.user.authentification.UserLoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.requireNonNull;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoginController {

    private final LoginUser loginUser;

    public LoginController(LoginUser loginUser) {
        this.loginUser = requireNonNull(loginUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserIdAndRolesDto> loginAndReturnRoles(@RequestBody UserLoginDto userLoginDto) {
        try {
            return new ResponseEntity<>(loginUser.verifyLogin(userLoginDto), HttpStatus.OK);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(new UserIdAndRolesDto(), HttpStatus.NOT_FOUND);
        }
    }
}
