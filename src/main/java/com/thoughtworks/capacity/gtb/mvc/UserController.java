package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id")long id){
        User user = userService.find(id);
        return user;
    }
    @GetMapping("/users/{id}/educations")
    public Education getUserEducation(@PathVariable("id")long id){
        Education education = userService.findUserEducation(id);
        return education;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PostMapping("/users/{id}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserEducation(@PathVariable("id")Integer id, @RequestBody Education edu){
        userService.addUserEducation(id, edu);
    }
}
