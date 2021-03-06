package com.example.task_example_DB.controller.api;


import com.example.task_example_DB.dao.impl.UserServiceImpl;
import com.example.task_example_DB.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserServiceImpl userService;

    @Autowired
    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public User updateUserById(@PathVariable(value = "id") Long id, @RequestBody User userUpdateDTO) {
        return userService.updateUserById(id, userUpdateDTO);
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable(value = "id") Long id) {
        userService.deleteUserById(id);
    }

    @ResponseBody
    @PostMapping
    public User createUser(@RequestBody User userCreateDTO) {
        return userService.createUser(userCreateDTO);
    }

}

