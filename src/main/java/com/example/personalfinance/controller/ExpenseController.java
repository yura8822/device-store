package com.example.personalfinance.controller;


import com.example.personalfinance.model.ExpenseItem;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    private List<ExpenseItem> expenseItems = new ArrayList<>();

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ExpenseItem> getListExpenditurer() {
        return this.expenseItems;
    }

    @ResponseBody
    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer getSumListExpenditurer() {
        int sum = 0;
        for (ExpenseItem value : this.expenseItems) {
            sum += value.getPrice();
        }
        return sum;
    }

    //curl -H "Content-Type: application/json" -X PUT -d '{"typeConsumption":"relax","price":"9999"}' http://localhost:8080/expenditure/1/
    @ResponseBody
    @PutMapping(value = "{expenditureID}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ExpenseItem updateItemExpenditure(@PathVariable("expenditureID") Long expenditureID, @RequestBody ExpenseItem expenseItemForID) {
        ExpenseItem expenseItem = null;
        for (ExpenseItem value : this.expenseItems) {
            if (value.getId() == expenditureID)
                expenseItem = value;
        }
        if (expenseItem != null) {
            expenseItem.setPrice(expenseItemForID.getPrice());
            expenseItem.setTypeConsumption(expenseItemForID.getTypeConsumption());
        }
        return expenseItem;
    }

    //curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/expenditure/1/
    @ResponseBody
    @DeleteMapping(value = "{expenditureID}")
    public ExpenseItem deleteItemExpenditure(@PathVariable("expenditureID") Long expenditureID) {
        ExpenseItem expenseItem = null;
        for (ExpenseItem value : this.expenseItems) {
            if (value.getId() == expenditureID)
                expenseItem = value;
        }
        if (expenseItem != null)
            this.expenseItems.remove(expenseItem);
        return expenseItem;
    }

    //curl -H "Content-Type: application/json" -X POST -d '{"typeConsumption":"eat","price":"987"}' http://localhost:8080/expenditure/
    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ExpenseItem createItemExpenditure(@RequestBody ExpenseItem newitemExpense) {
        ExpenseItem expenseItem = new ExpenseItem(expenseItems.size(), newitemExpense.getTypeConsumption(),
                newitemExpense.getPrice());
        this.expenseItems.add(expenseItem);
        return expenseItem;
    }


}













