package com.geekbrains.lesson7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;
    private final CountDownLatch latch;
    private final CountDownLatch latch2;
    private final CyclicBarrier cb;
    private final Semaphore smp;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch latch, CyclicBarrier cb, Semaphore smp, CountDownLatch latch2) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.latch = latch;
        this.cb = cb;
        this.smp = smp;
        this.latch2 = latch2;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            latch.countDown();
            System.out.println(this.name + " готов");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < race.getStages().size(); i++) {
            if (race.getStages().get(i).getClass().equals(Tunnel.class)) {
                try {
                    smp.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            race.getStages().get(i).go(this);
            if(i == race.getStages().size() - 1 && latch2.getCount() == CARS_COUNT) {
                System.out.println(this.getName() + " - WIN!");
            }
            if (race.getStages().get(i).getClass().equals(Tunnel.class)) {
                smp.release();
            }
        }
        latch2.countDown();
    }

}
