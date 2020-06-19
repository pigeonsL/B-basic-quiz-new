package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put(1, new User(1, "username1", "username_1", "username1@mail.com"));
        userMap.put(2, new User(2, "username2", "username_2", "username2@mail.com"));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }
    public User getUserById(Integer id) {
        return userMap.get(id);
    }
}
