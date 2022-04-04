package com.topspec.jobfinderv2.service.user.authentification;

public class UserLoginDto {
    private String usernameOrEmail;
    private String password;

    public UserLoginDto() {
    }

    public UserLoginDto(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }
}
