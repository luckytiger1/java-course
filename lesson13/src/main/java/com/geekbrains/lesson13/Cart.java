package com.geekbrains.lesson13;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<Product> container;

    public List<Product> getContainer() {
        return container;
    }

    public void add(Product product) {
        container.add(product);
    }

    @PostConstruct
    public void init() {
        container = new ArrayList<>();
    }
}
