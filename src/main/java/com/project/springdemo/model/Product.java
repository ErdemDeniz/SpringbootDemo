package com.project.springdemo.model;

public class Product {

    public Integer id;
    public String name;
    public Integer price;

    public Product() {
    }

    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return price;
    }
}
