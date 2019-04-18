package com.example.task_example_DB.controller.api;

import com.example.task_example_DB.dao.impl.ExpenseServiceImpl;
import com.example.task_example_DB.entity.Expence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private ExpenseServiceImpl expenseService;

    @Autowired
    public ExpenseController(ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }

    @ResponseBody
    @GetMapping
    public List<Expence> getAllExpense() {
        return expenseService.findAllExpense();
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Expence getExpenseById(@PathVariable(value = "id") Long id) {
        return expenseService.findExpenseById(id);
    }

    @ResponseBody
    @GetMapping(value = "amount/{amount}")
    public List<Expence> getExpenseAmountSort(@PathVariable(value = "amount") BigDecimal amount) {
        return expenseService.findAllExpenseBySort(amount);
    }

    @ResponseBody
    @PostMapping(value = "/{id}/{amount}")
    public Expence createExpense(@PathVariable(value = "id") Long id, @PathVariable(value = "amount") BigDecimal amount) {
        return expenseService.createExpense(id, amount);
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteExpense(@PathVariable(value = "id") Long id) {
        expenseService.deleteExpenseById(id);
    }

}
