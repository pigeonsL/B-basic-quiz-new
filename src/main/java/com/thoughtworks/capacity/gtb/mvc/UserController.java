package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //GET 登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserInfo(@RequestParam String name, @RequestParam String passwd){
        return userService.getAllUsers();
    }

    //POST register
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody User user){
        userService.addUser(user);
    }
}
