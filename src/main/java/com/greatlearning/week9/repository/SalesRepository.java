package com.greatlearning.week9.repository;

import com.greatlearning.week9.pojo.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales,Integer> {
}
