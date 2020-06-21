package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static Map<Integer, User> userMap = new HashMap<>();
    static {
        userMap.put(1, new User(1L, "KAMIL", 24L, "https://inews.gtimg.com/newsapp_match/0",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita Quasi"));
    }
    private static Map<Integer, Education> educationMap = new HashMap<>();
    static {
        educationMap.put(1, new Education(1L, 2005L, "Secondary school specializing in artistic",
                "Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus."));
    }
    public User find(long id){
        for(User user:userMap.values()){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
    public Education findUserEducation(long id){
        User user = find(id);
        if(user != null){
            for(Education edu : educationMap.values()){
                if(edu.getUserId() == id){
                    return edu;
                }
            }
        }
        return null;
    }

    public void addUser(User user){
        long count = userMap.size()+1;
        user.setId(count);
        userMap.put((int) user.getId(), user);
    }
    public void addUserEducation(Integer id, Education edu){
        User user = find(id);
        if(user != null){
            for(Education e : educationMap.values()){
                if(e.getUserId() == id){
                    e.setYear(edu.getYear());
                    e.setDescription(edu.getDescription());
                    e.setTitle(edu.getTitle());
                    educationMap.put(id, e);
                }
            }
        }
    }
}
