package com.greatlearning.week9;

import com.greatlearning.week9.pojo.Product;
import com.greatlearning.week9.repository.ProductRepository;
import com.greatlearning.week9.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ProductserviceTest {

    @Autowired
    ProductService productService;

    @MockBean
    ProductRepository productRepository;

    //PositiveTestCase
    @Test
    public void testCreateProduct(){
        Product product = new Product(10,"italian pasta","south",500f);

        Mockito.when(productRepository.save(product)).thenReturn(product);

        assertThat(productService.save(product)).isEqualTo(product);

    }

    @Test
    public void testgetAllProducts(){

        assertThat(productService.listAll().size()).isGreaterThanOrEqualTo(0);

    }

    //NegativeTestCase
    @Test
    public void testgetProduct(){

        Assertions.assertThrows(NoSuchElementException.class,
                ()->{
                    float test = productService.get(1).getPrice();
                });

    }


}
