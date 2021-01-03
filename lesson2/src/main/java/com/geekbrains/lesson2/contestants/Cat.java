package com.geekbrains.lesson2.contestants;

public class Cat implements Contestant{
    private final int maxDistance;
    private final int maxHeight;

    public Cat() {
        this.maxDistance = 100;
        this.maxHeight = 20;
    }

    @Override
    public boolean run(int distance) {
        if(distance >= maxDistance) {
            System.out.println("Cat can't run " + distance + " m.");
            return false;
        } else {
            System.out.println("Cat successfully ran " + distance + " m.");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if(height >= maxHeight) {
            System.out.println("Cat can't jump " + height + " m.");
            return false;
        } else {
            System.out.println("Cat successfully jumped " + height + " m.");
            return true;
        }
    }
}
