package com.project.springdemo;


import com.project.springdemo.model.Product;
import com.project.springdemo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RequestMapping(value = "/listProduct")//TODO
@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;
    //add
    @RequestMapping(path = "/addProduct")
    public Product addProduct(@RequestParam String name, @RequestParam int price) {
        Random random = new Random();
        Product result = null;
        int randomInt = 0;
        for (int idx = 1; idx <= 10; ++idx){
            randomInt = random.nextInt(20);
        }
        productService.add(randomInt, name, price);
        for (int i = 0; i < productService.list().size(); i++) {
            result = productService.list().get(i);
        }
        return result;
    }
    //delete
    @RequestMapping(path = "/deleteProduct")
    public boolean deleteProduct(@RequestParam int id) {
        Product product = productService.findBy(id);
        if (product != null){
            productService.delete(id);
            return true;
        }
        return false;
    }
    //update
    @RequestMapping(path = "/updateProduct")
    public Product updateProduct(@RequestParam int id,@RequestParam String name, @RequestParam int price) {
        Product product = productService.findBy(id);
        if (product!=null){
            productService.updateNameAndPrice(id, name, price);
            return product;
        }
        return null;
    }
    //list
    @RequestMapping(path = "/listProduct")
    public List<Product> listProduct() {
        return productService.list();
    }
    //findById
    @RequestMapping(path = "/findProduct")
    public Product findProduct(@RequestParam int id) {
        Product product = productService.findBy(id);
        if(product!=null)
            return product;
        return null;
    }

}
