package com.greatlearning.week9.repository;

import com.greatlearning.week9.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    public User getUserByUserId(@Param("id") Long id);
}
