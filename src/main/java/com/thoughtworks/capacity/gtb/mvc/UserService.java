package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    public String login(String name, String passwd){
        if(IsValidName(name)){
            return "用户名不合法";
        }
        if(IsValidPasswd(passwd)){
            for(User user: userMap.values()){
                if(user.getName() == name && user.getPasswd() == passwd){
                    return user.toString();
                }
            }
        }
        return "用户名或密码错误";
    }
    public boolean IsValidName(String name){
        if(name.length() >= 5 && name.length() <= 10){
            return true;
        }
        return false;
    }
    public boolean IsValidPasswd(String passwd){
        if(passwd.length() >= 5 && passwd.length() <= 12){
            Pattern pt = Pattern.compile("[\\w]+");
            Matcher mt = pt.matcher(passwd);
            if(mt.matches()){
                return true;
            }
        }
        return false;
    }
}
