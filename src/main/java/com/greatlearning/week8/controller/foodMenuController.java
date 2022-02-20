package com.greatlearning.week8.controller;

import com.greatlearning.week8.pojo.Product;
import com.greatlearning.week8.service.ProductService;
import com.sun.istack.NotNull;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class foodMenuController {
    @Autowired
    private ProductService service;

    @GetMapping("/getFullMenu")
    public List<Product> getFullMenu() {
        List<Product> listProducts = service.listAll();
        return listProducts;
    }

    @GetMapping("/getFullMenu/{id}")
    public Product getMenuById(@PathVariable @NotNull int id) {
        Product product = service.get(id);
        return product;
    }

    @PostMapping("/placeOrder/{food_ids}")
    public String buyByIds(@PathVariable @NotNull List<Integer> food_ids) {
        int sum=0;
        for(int food_id : food_ids){
            Product product = service.get(food_id);
            sum+=product.getPrice();
        }

        return "Total Bill Amount for cart is Rs."+sum;
    }
}
