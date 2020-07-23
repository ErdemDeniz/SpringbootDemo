package com.project.springdemo.model;

public class BasketItem {

    private int quantity;
    private Product product;

    public BasketItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer price() {
        return quantity * product.getPrice();
    }

}
