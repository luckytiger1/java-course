package com.geekbrains.lesson1.animals;

public class Dog extends Animal {

    @Override
    public void swim(int m) {
        if (m <= 10) {
            System.out.println("Dog swam " + m + " m.");
        } else {
            System.out.println("Dog can't swim this distance");
        }
    }

    @Override
    public void run(int m) {
        if (m <= 500) {
            System.out.println("Dog ran " + m + " m.");
        } else {
            System.out.println("Dog can't run this distance");
        }
    }
}
