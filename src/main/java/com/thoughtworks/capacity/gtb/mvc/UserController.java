package com.thoughtworks.capacity.gtb.mvc;

import com.thoughtworks.capacity.gtb.mvc.exception.UserErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //GET 登录
    @GetMapping("/login")
    public User login( String name, String passwd) throws UserErrorException {
        return userService.login(name, passwd);
    }

    //POST register
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody @Valid User user) throws UserErrorException {
        userService.addUser(user);
    }
}
