package com.geekbrains.lesson2.obstacles;

import com.geekbrains.lesson2.contestants.Contestant;

public class Treadmill implements Obstacle {
    int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean contest(Contestant contestant) {
        if (contestant.run(length)) {
            System.out.println(contestant.getClass().getSimpleName() + " ran distance!");
            return true;
        } else {
            System.out.println(contestant.getClass().getSimpleName() + " couldn't run distance!");
            return false;
        }
    }
}
