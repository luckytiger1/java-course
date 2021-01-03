package com.geekbrains.lesson1.animals;

public class Cat extends Animal {
    public static int count;

    public Cat(String name, int maxRunDistance) {
        super("Cat", name, maxRunDistance, 0);
        count++;
    }
}
