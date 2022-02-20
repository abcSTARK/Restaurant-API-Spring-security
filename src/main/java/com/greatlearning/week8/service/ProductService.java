package com.greatlearning.week8.service;

import java.util.List;

import com.greatlearning.week8.pojo.Product;
import com.greatlearning.week8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> listAll() {
        return repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product get(int food_id) {
        return repo.findById(food_id).get();
    }

    public void delete(int food_id) {
        repo.deleteById(food_id);
    }
}
