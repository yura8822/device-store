package com.example.personalfinance;

import com.example.personalfinance.controller.ExpenseController;
import com.example.personalfinance.model.ExpenseItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.hamcrest.Matchers.is;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpenseController.class)
public class PersonalFinanceApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testCreateExpenditure() throws Exception {

        mvc.perform(post("/expense")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ExpenseItem("eat", 1))))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("price", notNullValue()))
                .andExpect(jsonPath("price", is(1)));

        mvc.perform(post("/expense")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new ExpenseItem("eat", 1))))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("price", notNullValue()))
                .andExpect(jsonPath("id", is(1)));
    }

}
