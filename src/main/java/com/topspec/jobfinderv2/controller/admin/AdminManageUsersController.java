package com.topspec.jobfinderv2.controller.admin;

import com.topspec.jobfinderv2.service.CustomPageImpl;
import com.topspec.jobfinderv2.service.user.SearchUsers;
import com.topspec.jobfinderv2.service.user.UserSummary;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminManageUsersController {

    private final SearchUsers searchUsers;

    public AdminManageUsersController(SearchUsers searchUsers) {
        this.searchUsers = requireNonNull(searchUsers);
    }

    @GetMapping("/user/search")
    public CustomPageImpl<UserSummary> searchUsers(
            @RequestParam(value = "searchParam", required = false) String searchParam,
            @RequestParam("page") Integer page) {
        return searchUsers.findUsersByIdOrUsername(searchParam, page);
    }
}
