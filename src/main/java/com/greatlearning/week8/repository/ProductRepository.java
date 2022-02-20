package com.greatlearning.week8.repository;

import com.greatlearning.week8.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}