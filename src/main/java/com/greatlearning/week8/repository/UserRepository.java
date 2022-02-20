package com.greatlearning.week8.repository;

import com.greatlearning.week8.pojo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    @Query("SELECT * FROM User")
    public List<User> getAllUser();

    @Query("INSERT INTO users VALUES (:id, :email, :username, :password, 1)")
    public void addUser(@Param("id") int id,@Param("email") String email,@Param("username") String username,@Param("password") String password);

}
