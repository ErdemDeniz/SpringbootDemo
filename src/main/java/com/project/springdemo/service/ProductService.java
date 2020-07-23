package com.project.springdemo.service;

import org.springframework.stereotype.Service;

import com.project.springdemo.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<Product>();

    public ProductService() {

        products.add( new Product( 1, "nike air", 200 ) );
        products.add( new Product( 22, "addidas", 300 ) );

    }

    public void add(int id, String name, Integer quantity) {
        Product addProduct = null;
        addProduct = new Product( id, name, quantity );
        products.add( addProduct );
    }

    public void delete(Integer id) {

        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getId().equals(id)) {
                it.remove();
            }
        }
    }

    public void updateName(Integer id, String name) {
        for (Product product : products) {
            if (product.getId().equals( id )) {
                product.name = name;
            }
        }
    }

    public void updatePrice(Integer id,Integer price) {
        for (Product product : products) {
            if (product.getId().equals( id )) {
                product.price = price;
            }
        }
    }

    public void updateNameAndPrice(Integer id, String name, Integer price) {
        for (Product product : products) {
            if (product.getId().equals( id )) {
                product.name = name;
                product.price = price;
            }
        }
    }

    public List<Product> list() {
        for(int i = 0; i<products.size(); i++){
            System.out.println( products.get( i ) );
        }
        return products;}

    public Product findBy(int productId) {
        for (Product product : products) {
            if (product.getId().equals( productId )) {
                return product;
            }
        }
        return null;
    }

    public boolean findBy(int id, String name) {
        for (Product product : products)
            if (product.id == id & product.name.equalsIgnoreCase( name )) {
                return true;
            }
        return false;
    }

    public boolean findBy2(int id, int price) {
        for (Product product : products)
            if (product.id == id & product.price == price ) {
                return true;
            }
        return false;
    }

    public boolean findBy3(int id, String name, int price) {
        for (Product product : products)
            if (product.id == id & product.name.equalsIgnoreCase( name ) & product.price == price) {
                return true;
            }
        return false;
    }
}