package com.geekbrains.lesson6;

public class NotifyApp {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        NotifyApp waitNotifyApp = new NotifyApp();
        new Thread(waitNotifyApp::printA).start();
        new Thread(waitNotifyApp::printB).start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("i in A: " + i);
                    while (currentLetter != 'A') {
                        mon.wait();
                        System.out.println("A wait");
                    }
                    System.out.println("A");
                    currentLetter = 'B';
                    System.out.println("A pre Notify");
                    mon.notifyAll();
                    System.out.println("A post Notify");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("i in B: " + i);
                    while (currentLetter != 'B') {
                        mon.wait();
                        System.out.println("B wait");
                    }

                    System.out.println("B");
                    currentLetter = 'A';
                    System.out.println("B pre Notify");
                    mon.notifyAll();
                    System.out.println("B post Notify");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

