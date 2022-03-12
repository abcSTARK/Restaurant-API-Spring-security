package com.greatlearning.week9.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return ("<h1> Welcome ! Now Login and Go to Swagger Page </h1>");
    }
}
