package com.example.task_example_DB.repo;

import com.example.task_example_DB.entity.Expence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenceRepository extends JpaRepository<Expence, Long> {
    Expence findExpenceById(Long id);
}
