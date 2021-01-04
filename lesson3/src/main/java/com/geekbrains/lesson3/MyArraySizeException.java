package com.geekbrains.lesson3;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Array size is not 4x4");
    }
}
