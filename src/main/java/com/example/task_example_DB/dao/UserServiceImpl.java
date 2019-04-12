package com.example.task_example_DB.dao;

import com.example.task_example_DB.dao.Interfacedao.UserService;
import com.example.task_example_DB.entity.User;
import com.example.task_example_DB.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return usersRepository.findUserById(id);
    }

    @Override
    public User updateUserById(Long id, User userUpdateDTO) {
        User user = usersRepository.findUserById(id);
        user.setName(userUpdateDTO.getName());
        usersRepository.save(user);
        return user;
    }

    @Override
    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public User createUser(User userCreateDTO) {
        User user = new User(userCreateDTO.getName());
        usersRepository.save(user);
        return user;
    }
}
