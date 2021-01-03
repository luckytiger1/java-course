package com.geekbrains.lesson1;

import com.geekbrains.lesson1.animals.Animal;
import com.geekbrains.lesson1.animals.Cat;
import com.geekbrains.lesson1.animals.Dog;

public class MainApp {
    public static void main(String[] args) {
        Animal[] animals = {
          new Cat("Barsik", 200),
          new Dog("Rex", 500, 10),
          new Dog("Strelka", 300, 50)
        };

        for(Animal animal: animals) {
            animal.run(160);
            animal.swim(5);
        }

        System.out.println("Animals: " + Animal.count);
        System.out.println("Cats: " + Cat.count);
        System.out.println("Dogs: " + Dog.count);
    }
}
