package com.geekbrains.lesson1.animals;

public class Cat extends Animal {

    @Override
    public void swim(int m) {
        System.out.println("Cat can't swim");
    }

    @Override
    public void run(int m) {
        if (m <= 200) {
            System.out.println("Cat ran " + m + " m.");
        } else {
            System.out.println("Cat can't run this distance");
        }
    }
}
