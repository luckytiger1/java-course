package com.geekbrains.lesson13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService ps = context.getBean("productService", ProductService.class);
        Cart cart = context.getBean("cart", Cart.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);

        cart.add(ps.findByTitle("1a"));
        cart.add(ps.findByTitle("2a"));
        cart.add(ps.findByTitle("3a"));
        orderService.makeOrder();

        ((AnnotationConfigApplicationContext) context).close();
    }
}
