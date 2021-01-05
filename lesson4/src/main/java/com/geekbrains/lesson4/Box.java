package com.geekbrains.lesson4;

import com.geekbrains.lesson4.fruits.Fruit;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    public ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    @SafeVarargs
    public Box(T... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public final void add(T fruit) {
        this.fruits.add(fruit);
    }

    @SafeVarargs
    public final void add(T... fruits) {
        this.fruits.addAll(Arrays.asList(fruits));
    }

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0.0f;
        }
        return fruits.size() * fruits.get(0).getWeight();
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.00001;
    }

    public void moveToAnotherBox(Box<? super T> anotherBox) {
        if (this == anotherBox) {
            return;
        }
        anotherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
