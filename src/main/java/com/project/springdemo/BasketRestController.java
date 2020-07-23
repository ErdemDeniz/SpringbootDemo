package com.project.springdemo;


import com.project.springdemo.model.Basket;
import com.project.springdemo.model.Product;
import com.project.springdemo.service.BasketService;
import com.project.springdemo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/createBasket")//TODO
@RestController
public class BasketRestController {

    @Autowired private BasketService basketService;
    @Autowired private ProductService productService;

    //addToBasket
    @RequestMapping(path = "/addToBasket")
    public Basket addToBasket(@RequestParam int productId, @RequestParam int quantity) {

        Product product = productService.findBy(productId);
        basketService.addProduct(product, quantity);
        return basketService.getBasket();

    }

    //createBasket
    @RequestMapping(path = "/createBasket")
    public Basket createBasket() {
        basketService.createBasket();
        return basketService.getBasket();
    }
    //getBasketDetail
    @RequestMapping(path = "/getBasketDetail")
    public void getBasketDetail() {
        basketService.printBasketDetail();
    }

    //removeProduct
    @RequestMapping(path = "/removeProduct")
    public boolean removeProduct(@RequestParam int id) {
        Product product = productService.findBy(id);
        if (product!=null){
            basketService.removeProduct(product);
            return true;
        }

        return false;
    }
    //incrementQuantity
    @RequestMapping(path = "/incrementQuantity")
    public boolean incrementQuantity(@RequestParam int id,@RequestParam int quantity) {
        Product product = productService.findBy(id);
        if (product!=null){
            basketService.incrementQuantity(product,quantity);
            basketService.removeProduct(product);
            return true;
        }

        return false;
    }
    //decrementQuantity
    @RequestMapping(path = "/decrementQuantity")
    public boolean decrementQuantity(@RequestParam int id,@RequestParam int quantity) {
        Product product = productService.findBy(id);
        if (product!=null){
            basketService.decrementQuantity(product,quantity);
            basketService.removeProduct(product);
            return true;
        }

        return false;
    }
    //getBasketPrice
    @RequestMapping(path = "/getBasketPrice")
    public Integer getBasketPrice() {
        Basket basket = basketService.getBasket();
        return basket.calculateBasketPrice();

    }
}
