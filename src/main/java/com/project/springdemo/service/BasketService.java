package com.project.springdemo.service;


import org.springframework.stereotype.Service;

import com.project.springdemo.model.Basket;
import com.project.springdemo.model.BasketItem;
import com.project.springdemo.model.Product;

@Service
public class BasketService {

    private Basket basket = new Basket();

    public void createBasket() {
        basket = new Basket();
    }

    public void printBasketDetail() {
        Integer totalQuantity = 0;
        for (int i = 0; i < basket.getItems().size(); i++) {
            Integer quantity = basket.getItems().get(i).getQuantity();
            String productName = basket.getItems().get(i).getProduct().getName();
            Integer productPrice = basket.getItems().get(i).getProduct().getPrice();
            totalQuantity += basket.getItems().get(i).getQuantity();
            System.out.println("Product Name : " + productName + ", Product Quantity : " + quantity + ", Product Price : " + productPrice*quantity);
        }
        System.out.println("Product Number : " + basket.getItems().size() + ", Total Quantity : " + totalQuantity +", Total Basket Price : " + basket.calculateBasketPrice());
    }

    public void addProduct(Product product, Integer quantity){
        basket.addItem(new BasketItem(quantity, product));
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < basket.getItems().size(); i++) {
            if ((basket.getItems().get(i).getProduct().equals(product))){
                basket.getItems().remove(basket.getItems().get(i));
            }
        }
    }

    public void incrementQuantity(Product product, Integer quantity){
        for (int i = 0; i < basket.getItems().size(); i++) {
            if (basket.getItems().get(i).getProduct().equals(product)){
                Integer quantity1 = basket.getItems().get(i).getQuantity();
                BasketItem basketItem = new BasketItem(quantity1 + quantity, product);
                basket.getItems().set(i, basketItem);
            }
        }
    }

    public void decrementQuantity(Product product, Integer quantity){
        for (int i = 0; i < basket.getItems().size(); i++) {
            if (basket.getItems().get(i).getProduct().equals(product)){
                Integer quantity1 = basket.getItems().get(i).getQuantity();
                BasketItem basketItem = new BasketItem(quantity1 - quantity, product);
                if (basketItem.getQuantity() == 0){
                    removeProduct(product);
                } else {
                    basket.getItems().set(i, basketItem);
                }
            }
        }
    }

    public Basket getBasket() {
        return basket;
    }

    public Integer getBasketPrice() {
        return basket.calculateBasketPrice();
    }

}
