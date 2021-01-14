package com.geekbrains.lesson11;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "buyers")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<BuyerProduct> buyerProducts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BuyerProduct> getBuyerProducts() {
        return buyerProducts;
    }

    public void setBuyerProducts(List<BuyerProduct> buyerProducts) {
        this.buyerProducts = buyerProducts;
    }

    public Buyer() {
    }

    @Override
    public String toString() {
//        String allBuyerProducts = "";
//        for (BuyerProduct o : buyerProducts) {
//            allBuyerProducts += o.getTitle() + " ";
//        }
        return "Buyer [" + id + " " + name + " " + buyerProducts + "]";
    }
}
