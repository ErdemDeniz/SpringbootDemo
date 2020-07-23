package com.project.springdemo;

import java.util.List;

import com.project.springdemo.model.Product;

public interface Medify {

    void createProduct(Integer id, String name, Integer price);
    List<Product> findAllProducts();


}
