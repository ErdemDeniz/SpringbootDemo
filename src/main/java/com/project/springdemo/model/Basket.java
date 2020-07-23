package com.project.springdemo.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<BasketItem> items = new ArrayList<>();

    public void addItem(BasketItem item) {
        items.add(item);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public Integer calculateBasketPrice() {
        Integer totalPrice = 0;
        for (int i =0; i<items.size(); i++) {

            totalPrice  += items.get(i).price();

        }
        return totalPrice;
    }
}
