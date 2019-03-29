package com.example.devicestore.controller;


import com.example.devicestore.model.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> userArrayList = new ArrayList<>();
    private static File fileJson = new File("/home/dev1ubuntu/IdeaProjects/device-store/src/main/resources/jason.txt");


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(fileJson, userArrayList);
        return this.userArrayList;
    }

    //curl -H "Content-Type: application/json" -X PUT -d '{"name":"@@@","lastName":"$$$"}' http://localhost:8080/users/1/
    @ResponseBody
    @RequestMapping(value = "{userId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable("userId") Integer userId, @RequestBody User userNew) {
        User user = null;
        for (User obj: userArrayList) {
            if (obj.getId()== userId){
                user = obj;
            }
        }
        if (user != null){
            user.setName(userNew.getName());
            user.setLastName(userNew.getLastName());
        }
        return user;
    }

    //curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/users/1/
    @ResponseBody
    @RequestMapping(value = "{userId}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("userId") Integer userId) {
        User user = null;
        for (User obj: userArrayList) {
            if (obj.getId()== userId){
                user = obj;
            }
        }
        if (user != null){
            this.userArrayList.remove(user);
        }

    }

    //curl -H "Content-Type: application/json" -X POST -d '{"name":"NAME!!!!!","lastName":"LASTNAME!!!!!!!!!"}' http://localhost:8080/users/add/
    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        this.userArrayList.add(user);
        return new ResponseEntity("Successfully add user", new HttpHeaders(), HttpStatus.OK);
    }

}
