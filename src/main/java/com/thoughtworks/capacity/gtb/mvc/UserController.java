package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //GET 登录
    @GetMapping("/login")
    public User login( String name, String passwd){
        return userService.login(name, passwd);
    }

    //POST register
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody User user){
        userService.addUser(user);
    }
}
