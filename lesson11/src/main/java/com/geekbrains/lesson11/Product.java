package com.geekbrains.lesson11;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @OneToMany(mappedBy = "products")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<BuyerProduct> buyerProducts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BuyerProduct> getBuyerProducts() {
        return buyerProducts;
    }

    public void setBuyerProducts(List<BuyerProduct> buyerProducts) {
        this.buyerProducts = buyerProducts;
    }


    public Product() {
    }

    @Override
    public String toString() {
        return "Book [" + id + " " + title + " " + "]";
    }
}