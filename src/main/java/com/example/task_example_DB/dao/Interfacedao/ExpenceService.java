package com.example.task_example_DB.dao.Interfacedao;

import com.example.task_example_DB.entity.Expence;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenceService {
    List<Expence> findAllExpence();

    Expence findExpenceById(Long id);

    List<Expence> findAllExpenceBySort(BigDecimal amount);

    void deleteExpenceById(Long id);

    Expence createExpence(Long id, BigDecimal amount);
}
