package com.geekbrains.lesson2.contestants;

public class Robot implements Contestant {
    private final int maxDistance;
    private final int maxHeight;

    public Robot() {
        this.maxDistance = 1000;
        this.maxHeight = 100;
    }

    @Override
    public boolean run(int distance) {
        if(distance >= maxDistance) {
            System.out.println("Robot can't run " + distance + " m.");
            return false;
        } else {
            System.out.println("Robot successfully ran " + distance + " m.");
            return true;
        }
    }

    @Override
    public boolean jump(int height) {
        if(height >= maxHeight) {
            System.out.println("Robot can't jump " + height + " m.");
            return false;
        } else {
            System.out.println("Robot successfully jumped " + height + " m.");
            return true;
        }
    }
}
