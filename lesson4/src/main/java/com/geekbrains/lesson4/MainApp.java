package com.geekbrains.lesson4;

import com.geekbrains.lesson4.fruits.Apple;
import com.geekbrains.lesson4.fruits.Fruit;
import com.geekbrains.lesson4.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        String[] strList = {"as", "sa", "ew"};
        Integer[] intList = {1, 2, 3};

        ArrayList<String> newArr = arrayToArrayList(strList);
        ArrayList<Integer> newArr2 = arrayToArrayList(intList);
        System.out.println(newArr);
        System.out.println(newArr2);
        changePos(intList, 1, 2);

        Box<Apple> appleBox = new Box<>(new Apple());
        Box<Apple> appleBox2 = new Box<>(new Apple());
        Box<Orange> orangeBox = new Box<>(new Orange());
        Box<Fruit> fruitBox = new Box<>();

        appleBox.moveToAnotherBox(fruitBox);
        appleBox.moveToAnotherBox(appleBox2);

        System.out.println(orangeBox.getWeight());
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static <T> void changePos(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        System.out.println(Arrays.toString(arr));
    }
}
