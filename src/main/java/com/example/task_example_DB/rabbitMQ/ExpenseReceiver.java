package com.example.task_example_DB.rabbitMQ;

import com.example.task_example_DB.dao.impl.CategoryServiceImpl;
import com.example.task_example_DB.dao.impl.ExpenseServiceImpl;
import com.example.task_example_DB.dao.impl.UserServiceImpl;
import com.example.task_example_DB.dto.ExpenseCreateInfo;
import com.example.task_example_DB.entity.Category;
import com.example.task_example_DB.entity.Expence;
import com.example.task_example_DB.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ExpenseReceiver {

    private final ExpenseServiceImpl expenseService;

    @Autowired
    public ExpenseReceiver( ExpenseServiceImpl expenseService) {
        this.expenseService = expenseService;
    }
    public void receiveMessage(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        ExpenseCreateInfo expenseCreateInfo  = mapper.readValue(message, ExpenseCreateInfo.class);


        this.expenseService.createExpense(expenseCreateInfo.getUserId(),expenseCreateInfo.getAmount());
    }
}
