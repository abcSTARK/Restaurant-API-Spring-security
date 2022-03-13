package com.greatlearning.week9.service;

import com.greatlearning.week9.pojo.Sales;
import com.greatlearning.week9.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SalesService {

    int n=1;

    @Autowired
    SalesRepository salesRepository;

    public List<Sales> listAll() {
        return salesRepository.findAll();
    }

    public void createEntry(int sum) {
        salesRepository.save(new Sales(n,"order number "+n,sum));
        n++;
    }

    public int totalSales() {
        List<Sales> list =salesRepository.findAll();
        int sum=0;
        for (Sales sale: list
             ) {
            sum+= sale.getAmount();
        }
        return sum;
    }
}
