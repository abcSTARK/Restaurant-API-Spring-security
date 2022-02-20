package com.greatlearning.week8.service;


import com.greatlearning.week8.pojo.User;
import com.greatlearning.week8.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository repo;


    public List<User> listAll() {
        return repo.findAll();
    }

    public User get(Long id) {
        return repo.getUserByUserId(id);
    }

    public void addUser(User user) {
        repo.save(user);
    }
}
