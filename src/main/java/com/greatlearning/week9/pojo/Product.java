package com.greatlearning.week9.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="product")
public class Product {
    private int food_id;
    private String name;
    private String madein;
    private float price;

    public Product(int food_id, String name, String madein, float price) {
        this.food_id = food_id;
        this.name = name;
        this.madein = madein;
        this.price = price;
    }

    public Product() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getFood_id() {
        return food_id;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getName() {
        return name;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }
    @GeneratedValue(strategy = GenerationType.AUTO)
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "food_id=" + food_id +
                ", name='" + name + '\'' +
                ", madein='" + madein + '\'' +
                ", price=" + price +
                '}';
    }
}