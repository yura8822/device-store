package com.example.devicestore.controller;


import com.example.devicestore.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> userArrayList = new ArrayList<>();

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return this.userArrayList;
    }


    @ResponseBody
    @RequestMapping(value = "{userId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable("userId") Integer userId) {
        User user = this.userArrayList.get(userId);
        user.setName("name "+ Math.random());
        user.setLastName("last name " + Math.random());
        user.setDateBirth(new Date());
        this.userArrayList.set(userId, user);
        return user;
    }


    @ResponseBody
    @RequestMapping(value = "{userId}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") Integer userId) {
        this.userArrayList.remove(userId);
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody String name, String lastName, Date date) {
        User user = new User(name, lastName, date);
        this.userArrayList.add(user);
        return user;
    }

}
