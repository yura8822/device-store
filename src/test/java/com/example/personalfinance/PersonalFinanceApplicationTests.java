package com.example.personalfinance;

import com.example.personalfinance.controller.ExpenseController;
import com.example.personalfinance.model.ExpenseItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpenseController.class)
public class PersonalFinanceApplicationTests {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ExpenseController expenseController;

    private List<ExpenseItem> expenseItems;

//    @test
//    public void testCreateExpenditure() throws Exception {
//
//        mvc.perform(post("/expense")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new ExpenseItem("eat", 1))))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(jsonPath("price", notNullValue()))
//                .andExpect(jsonPath("price", is(1)));
//
//        mvc.perform(post("/expense")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new ExpenseItem("eat", 1))))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(jsonPath("price", notNullValue()))
//                .andExpect(jsonPath("id", is(1)));
//
//    }

    @Before
    public void mockExpenseItemInController() {
        expenseItems = Arrays.asList(
                new ExpenseItem(1, "eat", 100),
                new ExpenseItem(2, "entertainment", 999),
                new ExpenseItem(3, "relax", 333)
        );

        ReflectionTestUtils.setField(
                expenseController,
                "expenseItems",
                expenseItems
        );
    }

    @Test
    public void testGetListExpenditurer() throws Exception {

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

    @After
    public void clearExpenseItemInController() {
        expenseItems = new ArrayList<>();

        ReflectionTestUtils.setField(
                expenseController,
                "expenseItems",
                expenseItems
        );
    }

//    @Before
//    public void mockExpenseItemInControllerForUpdate() {
//        expenseItems = Arrays.asList(
//                new ExpenseItem(1,"eat", 100),
//                new ExpenseItem(2,"entertainment", 999),
//                new ExpenseItem(3, "relax", 333)
//        );
//
//        ReflectionTestUtils.setField(
//                expenseController,
//                "expenseItems",
//                expenseItems
//        );
//    }
//
//    @test
//    public void testUpdateItemExpenditure() throws Exception {
//
//        for (int i = 0; i <=3; i++) {
//            ExpenseItem expenseItem = new ExpenseItem(i,"hostel", 777);
//
//            mvc.perform(put("/expense/{expenditureID}", expenseItem.getId())
//                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
//                    .content(objectMapper.writeValueAsString(expenseItem)))
//
//                    .andExpect(status().isOk())
//                    .andDo(print())
//
//                    .andExpect((jsonPath("id",is(i))))
//                    .andExpect((jsonPath("typeConsumption",is("hostel"))))
//                    .andExpect((jsonPath("price",is(777))));
//        }
//
//        mvc.perform(get("/expense"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//
//                .andExpect(jsonPath("$", hasSize(3)))
//                .andExpect(jsonPath("$[0].id", is(1)))
//                .andExpect(jsonPath("$[0].typeConsumption", is("hostel")))
//                .andExpect(jsonPath("$[0].price", is(777)))
//
//                .andExpect(jsonPath("$[1].id", is(2)))
//                .andExpect(jsonPath("$[1].typeConsumption", is("hostel")))
//                .andExpect(jsonPath("$[1].price", is(777)))
//
//                .andExpect(jsonPath("$[2].id", is(3)))
//                .andExpect(jsonPath("$[2].typeConsumption", is("hostel")))
//                .andExpect(jsonPath("$[2].price", is(777)));
//    }
//
//    @After
//    public void clearExpenseItemInControllerForUpdate() {
//        expenseItems = new ArrayList<>();
//
//        ReflectionTestUtils.setField(
//                expenseController,
//                "expenseItems",
//                expenseItems
//        );
//    }
//
//    @Before
//    public void mockExpenseItemInControllerForDelete() {
//        expenseItems = Arrays.asList(
//                new ExpenseItem(1,"eat", 100),
//                new ExpenseItem(2,"entertainment", 999),
//                new ExpenseItem(3, "relax", 333)
//        );
//
//        ReflectionTestUtils.setField(
//                expenseController,
//                "expenseItems",
//                expenseItems
//        );
//    }
//
//    @test
//    public void testDeleteItemExpenditure() throws Exception {
//
//        mvc.perform(delete("/expense/1")
//                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//
//                .andExpect((jsonPath("id",is(1))))
//                .andExpect((jsonPath("typeConsumption",is("eat"))))
//                .andExpect((jsonPath("price",is(100))));
//
//        mvc.perform(get("/expense"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//                .andExpect(jsonPath("$", hasSize(2)));
//    }
//
//    @After
//    public void clearExpenseItemInControllerForDelete() {
//        expenseItems = new ArrayList<>();
//
//        ReflectionTestUtils.setField(
//                expenseController,
//                "expenseItems",
//                expenseItems
//        );
//    }


}
