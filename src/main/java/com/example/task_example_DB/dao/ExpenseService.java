package com.example.task_example_DB.dao;

import com.example.task_example_DB.entity.Expence;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseService {
    List<Expence> findAllExpense();

    Expence findExpenseById(Long id);

    List<Expence> findAllExpenseBySort(BigDecimal amount);

    void deleteExpenseById(Long id);

    Expence createExpense(Long id, BigDecimal amount);
}
