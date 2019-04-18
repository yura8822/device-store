package com.example.task_example_DB.dao.impl;

import com.example.task_example_DB.dao.ExpenseService;
import com.example.task_example_DB.entity.Expence;
import com.example.task_example_DB.repo.CategoryRepository;
import com.example.task_example_DB.repo.ExpenceRepository;
import com.example.task_example_DB.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenceRepository expenceRepository;
    private UsersRepository usersRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenceRepository expenceRepository, UsersRepository usersRepository, CategoryRepository categoryRepository) {
        this.expenceRepository = expenceRepository;
        this.usersRepository = usersRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Expence> findAllExpense() {
        return expenceRepository.findAll();
    }

    @Override
    public Expence findExpenseById(Long id) {
        return expenceRepository.findExpenceById(id);
    }

    @Override
    public List<Expence> findAllExpenseBySort(BigDecimal amount) {
        return expenceRepository.findByAmount(amount);
    }

    @Override
    public void deleteExpenseById(Long id) {
        expenceRepository.deleteById(id);
    }

    @Override
    public Expence createExpense(Long id, BigDecimal amount) {
        Expence expence = new Expence(categoryRepository.findCategoryById(id), usersRepository.findUserById(id), amount);
        expenceRepository.save(expence);
        return expence;
    }
}
