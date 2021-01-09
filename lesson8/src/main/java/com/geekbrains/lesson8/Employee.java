package com.geekbrains.lesson8;

public class Employee {
    public String name;
    public int age;
    public int salary;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
