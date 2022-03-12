package com.greatlearning.week9.controller;

import com.greatlearning.week9.pojo.Product;
import com.greatlearning.week9.service.ProductService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class foodMenuController {
    @Autowired
    private ProductService service;

    @GetMapping("/getFullMenu")
    public List<Product> getFullMenu() {
        log.info("Inside get FULL MENU");
        List<Product> listProducts = service.listAll();
        return listProducts;
    }

    @GetMapping("/getFullMenu/{id}")
    public Product getMenuById(@PathVariable @NotNull int id) {
        log.info("Inside get menu by product id");
        Product product = service.get(id);
        return product;
    }

    @PostMapping("/placeOrder/{food_ids}")
    public String buyByIds(@PathVariable @NotNull List<Integer> food_ids) {
        log.info("Inside Placing Order Screen");
        int sum=0;
        for(int food_id : food_ids){
            Product product = service.get(food_id);
            sum+=product.getPrice();
        }

        return "Total Bill Amount for cart is Rs."+sum;
    }
}
