package com.example.devicestore.controller;


import com.example.devicestore.model.ItemExpenditure;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/expenditure")
public class ExpenditureController {
    private List<ItemExpenditure> arrayList = new ArrayList<>();

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemExpenditure> getListExpenditurer() {
        return this.arrayList;
    }

    @ResponseBody
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer getSumListExpenditurer() {
        int sum = 0;
        for (ItemExpenditure value : this.arrayList) {
            sum += value.getPrice();
        }
        return sum;
    }

    //curl -H "Content-Type: application/json" -X PUT -d '{"typeConsumption":"relax","price":"9999"}' http://localhost:8080/expenditure/1/
    @ResponseBody
    @RequestMapping(value = "{expenditureID}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemExpenditure updateItemExpenditure(@PathVariable("expenditureID") Long expenditureID, @RequestBody ItemExpenditure itemExpenditureForID) {
        ItemExpenditure itemExpenditure = null;
        for (ItemExpenditure value : this.arrayList) {
            if (value.getId() == expenditureID)
                itemExpenditure = value;
        }
        if (itemExpenditure != null) {
            itemExpenditure.setPrice(itemExpenditureForID.getPrice());
            itemExpenditure.setTypeConsumption(itemExpenditureForID.getTypeConsumption());
        }
        return itemExpenditure;
    }

    //curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/expenditure/1/
    @ResponseBody
    @RequestMapping(value = "{expenditureID}", method = RequestMethod.DELETE)
    public ItemExpenditure deleteItemExpenditure(@PathVariable("expenditureID") Long expenditureID) {
        ItemExpenditure itemExpenditure = null;
        for (ItemExpenditure value : this.arrayList) {
            if (value.getId() == expenditureID)
                itemExpenditure = value;
        }
        if (itemExpenditure != null)
            this.arrayList.remove(itemExpenditure);
        return itemExpenditure;
    }

    //curl -H "Content-Type: application/json" -X POST -d '{"typeConsumption":"eat","price":"987"}' http://localhost:8080/expenditure/
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ItemExpenditure createItemExpenditure(@RequestBody ItemExpenditure newitemExpenditure) {
        ItemExpenditure itemExpenditure = new ItemExpenditure(newitemExpenditure.getTypeConsumption(),
                newitemExpenditure.getPrice());
        this.arrayList.add(itemExpenditure);
        return itemExpenditure;
    }


}













