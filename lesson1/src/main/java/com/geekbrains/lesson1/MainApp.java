package com.geekbrains.lesson1;

import com.geekbrains.lesson1.animals.Animal;
import com.geekbrains.lesson1.animals.Cat;
import com.geekbrains.lesson1.animals.Dog;

public class MainApp {
    public static void main(String[] args) {
        Animal[] animals = {
          new Cat(),
          new Dog()
        };

        for(Animal animal: animals) {
            animal.run(160);
            animal.swim(5);
        }
    }
}
