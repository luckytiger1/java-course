package com.geekbrains.lesson1.animals;

public abstract class Animal {
    public static int count;
    String type;
    String name;
    int maxRunDistance;
    int maxSwimDistance;

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        count++;
    }

    public void swim(int distance) {
        if(maxSwimDistance == 0) {
            System.out.println(type + " " + name + " can't swim.");
        }
        if(distance <= maxSwimDistance) {
            System.out.println(type + " " + name + " successfully swam " + distance + " m.");
        } else {
            System.out.println(type + " " + name + " couldn't swim provided distance.");
        }
    };

    public void run(int distance) {
        if(distance <= maxRunDistance) {
            System.out.println(type + " " + name + " successfully ran " + distance + " m.");
        } else {
            System.out.println(type + " " + name + " couldn't run provided distance.");
        }
    };
}
