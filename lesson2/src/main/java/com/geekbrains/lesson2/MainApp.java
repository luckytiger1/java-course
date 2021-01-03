package com.geekbrains.lesson2;

import com.geekbrains.lesson2.contestants.Cat;
import com.geekbrains.lesson2.contestants.Contestant;
import com.geekbrains.lesson2.contestants.Human;
import com.geekbrains.lesson2.contestants.Robot;
import com.geekbrains.lesson2.obstacles.Obstacle;
import com.geekbrains.lesson2.obstacles.Treadmill;
import com.geekbrains.lesson2.obstacles.Wall;

public class MainApp {
    public static void main(String[] args) {
        Obstacle[] obstacles = {
                new Wall(50),
                new Wall(200),
                new Treadmill(170),
                new Treadmill(300),
        };

        Contestant[] contestants = {
                new Robot(),
                new Cat(),
                new Human(),
        };

        for (Contestant c : contestants) {
            for (Obstacle o : obstacles) {
                if (!o.contest(c)) break;
            }
        }
    }
}
