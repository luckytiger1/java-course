package com.geekbrains.lesson13;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductService {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = Arrays.asList(
                new Product(1L, "1a", 10),
                new Product(2L, "2a", 20),
                new Product(3L, "3a", 30),
                new Product(4L, "4a", 40),
                new Product(5L, "5a", 50)
        );
    }

    public void printAll() {
        products.forEach(i -> System.out.println(i.getTitle()));
    }

    public Product findByTitle(String title)  {
        return products.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
    }
}
