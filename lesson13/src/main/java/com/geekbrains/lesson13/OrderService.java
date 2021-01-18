package com.geekbrains.lesson13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {

    @Autowired
    Cart cart;

    public void makeOrder() {
        List<Product> products = cart.getContainer();

        System.out.println("Your order: ");

        for (Product p : products) {
            System.out.println(p.getTitle());
        }

        System.out.println("Total cost: " + products.stream().mapToInt(Product::getCost).sum());
    }
}
