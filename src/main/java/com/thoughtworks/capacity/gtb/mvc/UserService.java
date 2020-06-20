package com.thoughtworks.capacity.gtb.mvc;

import com.thoughtworks.capacity.gtb.mvc.exception.UserErrorException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put(1, new User(1, "username1", "username_1", "username1@mail.com"));
        userMap.put(2, new User(2, "username2", "username_2", "username2@mail.com"));
    }

    public void addUser(User user) throws UserErrorException {
        if(userMap.values().stream().anyMatch(u -> u.getName().equals(user.getName()))){
            throw new UserErrorException("用户已存在");
        }
        int count = userMap.size() + 1;
        user.setId(count);
        userMap.put(user.getId(), user);
    }

    public User login(String name, String passwd) {
        for(User user: userMap.values()){
            if(user.getName().equals(name) && user.getPasswd().equals(passwd)){
                return user;
            }
        }
        return null;
    }
}
