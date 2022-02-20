package com.greatlearning.week8.service;

import com.greatlearning.week8.pojo.User;
import com.greatlearning.week8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public class UserDetailsServiceImpl implements UserDetailsService,AdminService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find Restaurant User");
        }

        return new MyUserDetails(user);
    }

    public List<User> listAll() {
        return userRepository.getAllUser();
    }

    public User get(String name) {
        User user  =userRepository.getUserByUsername(name);

        return user;
    }

    public void addUser(int id, String username, String password, String email) {
        userRepository.addUser(id,email,username,password);
    }
}
