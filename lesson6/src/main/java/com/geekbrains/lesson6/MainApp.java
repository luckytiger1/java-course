package com.geekbrains.lesson6;

import java.util.Arrays;

public class MainApp {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    private static final float[] arr = new float[SIZE];
    static final Integer mon = 0;

    public static void main(String[] args) {
        method1(arr);
        method2();

        new Thread(() -> {
            synchronized (mon) {
                try {
                    mon.wait();
                    System.out.println("thread 1 continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);

                synchronized (mon) {
                    mon.notifyAll();
                    Thread.sleep(10000);
                    System.out.println("thread 2 done");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void method1(float[] array) {
        Arrays.fill(array, 1.0f);

        long a = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);

    }

    public static void method2() {
        long a = System.currentTimeMillis();
        Arrays.fill(arr, 1.0f);
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0, j = HALF; i < a2.length; i++, j++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        long timeToCombine = System.currentTimeMillis() - a;
        System.out.println("Time to combine arrays: " + timeToCombine);
    }
}
