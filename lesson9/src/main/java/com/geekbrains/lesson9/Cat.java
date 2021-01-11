package com.geekbrains.lesson9;

@Table(title = "cats")
public class Cat {
    @Column
    int id;

    @Column
    String name;

    @Column
    String color;

    @Column
    int weight;
}
