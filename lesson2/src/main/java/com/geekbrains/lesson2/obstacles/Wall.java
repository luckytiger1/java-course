package com.geekbrains.lesson2.obstacles;

import com.geekbrains.lesson2.contestants.Contestant;

public class Wall implements Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean contest(Contestant contestant) {
        if (contestant.jump(height)) {
            System.out.println(contestant.getClass().getSimpleName() + " jumped height!");
            return true;
        } else {
            System.out.println(contestant.getClass().getSimpleName() + " couldn't jump height!");
            return false;
        }
    }
}
