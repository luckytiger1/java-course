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
                new Treadmill(170),
        };

        Contestant[] contestants = {
                new Robot(),
                new Cat(),
                new Human(),
        };

        for (Obstacle o: obstacles) {
            for(Contestant c: contestants) {
                if(!o.contest(c)) break;
            }
        }
    }
}
