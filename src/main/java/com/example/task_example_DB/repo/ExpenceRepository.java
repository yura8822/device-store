package com.example.task_example_DB.repo;

import com.example.task_example_DB.entity.Expence;
import com.example.task_example_DB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenceRepository extends JpaRepository<Expence, Long> {
    Expence findExpenceById(Long id);

    @Query("select u from Expence u where u.amount > ?1")
    List<Expence> findByAmount(BigDecimal amount);
}

