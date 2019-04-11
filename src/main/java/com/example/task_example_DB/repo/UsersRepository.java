package com.example.task_example_DB.repo;


import com.example.task_example_DB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
}

