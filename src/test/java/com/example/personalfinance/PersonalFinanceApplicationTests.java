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

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    public void testGetListExpenditurer() throws Exception {
        ExpenseController.expenseItems.add(new ExpenseItem(1,"eat", 100));
        ExpenseController.expenseItems.add(new ExpenseItem(2,"entertainment", 999));
        ExpenseController.expenseItems.add(new ExpenseItem(3, "relax", 333));

        mvc.perform(get("/expense"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].typeConsumption", is("eat")))
                .andExpect(jsonPath("$[0].price", is(100)))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].typeConsumption", is("entertainment")))
                .andExpect(jsonPath("$[1].price", is(999)))

                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].typeConsumption", is("relax")))
                .andExpect(jsonPath("$[2].price", is(333)));
    }

    @Test
    public void TestUpdateItemExpenditure() throws Exception {
        ExpenseController.expenseItems.add(new ExpenseItem(1,"eat", 100));
        ExpenseController.expenseItems.add(new ExpenseItem(2,"entertainment", 999));
        ExpenseController.expenseItems.add(new ExpenseItem(3, "relax", 333));

        for (int i = 1; i <=ExpenseController.expenseItems.size(); i++) {
            ExpenseItem expenseItem = new ExpenseItem(i,"hostel", 777);

            mvc.perform(put("/expense/{expenditureID}", expenseItem.getId())
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .content(objectMapper.writeValueAsString(expenseItem)))

                    .andExpect(status().isOk())
                    .andDo(print())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                    .andExpect((jsonPath("id",is(i))))
                    .andExpect((jsonPath("typeConsumption",is("hostel"))))
                    .andExpect((jsonPath("price",is(777))));
        }

        mvc.perform(get("/expense"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].typeConsumption", is("hostel")))
                .andExpect(jsonPath("$[0].price", is(777)))

                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].typeConsumption", is("hostel")))
                .andExpect(jsonPath("$[1].price", is(777)))

                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[2].typeConsumption", is("hostel")))
                .andExpect(jsonPath("$[2].price", is(777)));
    }

    @Test
    public void TestDeleteItemExpenditure() throws Exception {
        ExpenseController.expenseItems.add(new ExpenseItem(1,"eat", 100));
        ExpenseController.expenseItems.add(new ExpenseItem(2,"entertainment", 999));
        ExpenseController.expenseItems.add(new ExpenseItem(3, "relax", 333));

        mvc.perform(delete("/expense/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))

                .andExpect((jsonPath("id",is(1))))
                .andExpect((jsonPath("typeConsumption",is("eat"))))
                .andExpect((jsonPath("price",is(100))));

        mvc.perform(get("/expense"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)));
    }

}
