package com.geekbrains.lesson8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>(Arrays.asList("cat", "dog", "horse", "table", "dog", "cat", "dog"));
        String counts = strList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get().getKey();

        System.out.println(counts);

        List<Employee> empList = new ArrayList<>(Arrays.asList(
                new Employee("John", 30, 10000),
                new Employee("Martin", 32, 20000),
                new Employee("Mike", 34, 30000),
                new Employee("Luke", 35, 22000),
                new Employee("Dart", 45, 40000)));

        Integer avgSalary = empList.stream()
                .map(Employee::getSalary)
                .reduce(0, Integer::sum) / empList.size();

        double avgSalary2 = empList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);


        System.out.println(avgSalary);
        System.out.println(avgSalary2);

        printOldest(empList, 3);
    }

    public static void printOldest(List<Employee> empList, int n){
        System.out.println();
        String test = empList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(n)
                .map(Employee::getName)
                .collect(Collectors.joining(", ", n + " самых старших сотрудников зовут:\n", ";"));

        System.out.println(test);
    }
}
