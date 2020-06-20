package com.thoughtworks.capacity.gtb.mvc;

import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put(1, new User(1, "username1", "username_1", "username1@mail.com"));
        userMap.put(2, new User(2, "username2", "username_2", "username2@mail.com"));
    }

    public void addUser(User user) throws UserNotFoundException {
        if(!IsValidPasswd(user.getPasswd()))
            throw new UserNotFoundException("密码不合法");
        int count = userMap.size() + 1;
        user.setId(count);
        userMap.put(user.getId(), user);
    }

    public User login(String name, String passwd) throws UserNotFoundException {
        if(IsValidPasswd(passwd)){
            for(User user: userMap.values()){
                if(user.getName().equals(name) && user.getPasswd().equals(passwd)){
                    return user;
                }
            }
        }
        throw new UserNotFoundException("用户名或密码错误");
    }
    public boolean IsValidPasswd(String passwd){
        if(passwd.length() >= 5 && passwd.length() <= 12){
            Pattern pt = Pattern.compile("^\\w+$");
            Matcher mt = pt.matcher(passwd);
            if(mt.matches()){
                return true;
            }
        }
        return false;
    }
}
