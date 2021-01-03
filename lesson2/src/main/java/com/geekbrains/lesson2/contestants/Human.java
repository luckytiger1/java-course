package com.geekbrains.lesson2.contestants;

public class Human implements Contestant{
    private final int maxDistance;
    private final int maxHeight;

    public Human() {
        this.maxDistance = 300;
        this.maxHeight = 10;
    }

    @Override
    public boolean run(int distance) {
        if(distance >= maxDistance) {
            System.out.println("Human can't run " + distance + " m.");
            return false;
        } else {
            System.out.println("Human successfully ran " + distance + " m.");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if(height >= maxHeight) {
            System.out.println("Human can't jump " + height + " m.");
            return false;
        } else {
            System.out.println("Human successfully jumped " + height + " m.");
            return true;
        }
    }
}
