package com.geekbrains.lesson3;

public class MyArrayDataException extends RuntimeException{

    public MyArrayDataException(int row, int column, String[][] array) {
        super("Invalid data in [" + row + "; " + column + "]: " + array[row][column]);
    }
}
