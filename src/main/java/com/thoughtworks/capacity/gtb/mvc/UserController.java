package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //GET

    //POST
}
