package com.greatlearning.week9.controller;

import com.greatlearning.week9.pojo.Product;
import com.greatlearning.week9.service.ProductService;
import com.greatlearning.week9.service.SalesService;
import com.sun.istack.NotNull;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class foodMenuController {
    @Autowired
    private ProductService service;
    @Autowired
    private SalesService salesService;

    //FLAT 50 OFF Menu
    @GetMapping("/getFullFestiveMenu/{code}")
    public List<Product> getFullMenu(@PathVariable(value = "code") @NotNull String code) {
        if(code.equalsIgnoreCase("FLAT50")) {
            log.info("Inside get FULL MENU");
            List<Product> listProducts = service.listAll();
            for (Product p: listProducts
                 ) {
                p.setPrice(p.getPrice()/2);

            }
            return listProducts;
        }
        else
            return null;
    }

    //Billing after 50 % OFF
    @PostMapping("/placeFestiveOrder/{id}&{code}")
    public String buyByIds(@PathVariable(value="id") @NotNull List<Integer> food_ids,@PathVariable(value = "code") @NotNull String code) {
        log.info("Inside discounted Placing Order Screen");
        int sum=0;
        for(int food_id : food_ids){
            Product product = service.get(food_id);
            sum+=(product.getPrice()); //50 percent off
        }
        salesService.createEntry(sum);

        return "Total Bill Amount for cart is Rs."+sum/2; //50 percent off
    }
}
