package com.example.task_example_DB.dao;

import com.example.task_example_DB.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findUserById(Long id);

    User updateUserById(Long id, User userUpdateDTO);

    void deleteUserById(Long id);

    User createUser(User userCreateDTO);
}

