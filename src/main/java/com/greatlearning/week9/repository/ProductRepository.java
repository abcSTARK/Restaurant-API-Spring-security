package com.greatlearning.week9.repository;

import com.greatlearning.week9.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}