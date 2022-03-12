package com.greatlearning.week9.controller;

import com.greatlearning.week9.pojo.User;

import com.greatlearning.week9.service.AdminService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class AdminController {


    @Autowired
    private AdminService service;


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        log.info("Inside get All Users");
        List<User> listUsers = service.listAll();
        log.info("All users are :"+listUsers.toString());
        return listUsers;
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable @NotNull Long id) {
        log.info("Inside get User by ID");
        User user = service.get(id);
        return user;
    }

    @PostMapping("/addUser")
    public User addUser(@RequestParam Long id, String username , String password, String email) {
        log.info("Adding user by Id");
        User user = new User(id,username,password,email,true);

        return service.addUser(user);
    }
}
