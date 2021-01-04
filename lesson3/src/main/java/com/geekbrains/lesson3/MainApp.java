package com.geekbrains.lesson3;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        String[][] myArray = {
                {"1", "2", "3", "7"},
                {"4", "5", "6", "9"},
                {"7", "4", "9", "3"},
                {"7", "3", "9", "3"},
        };

        calculateSum(myArray);
    }

    public static void calculateSum(String[][] myArr) throws MyArraySizeException {
        if (myArr.length != 4) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < myArr.length; i++) {
            for (int j = 0; j < myArr[i].length; j++) {
                if (myArr[i].length != 4) throw new MyArraySizeException();
                try {
                    sum += Integer.parseInt(myArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, myArr);
                }
            }
        }

        System.out.println("Sum is: " + sum);
    }

}
