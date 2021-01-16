package com.geekbrains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.OptimisticLockException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) {
        try {
            prepareData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doSomething();
        countSum();
    }

    public static void prepareData() throws IOException {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;

        try {
            String sql = Files.lines(Paths.get("drop-and-create-table.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } finally {
            factory.close();
            if (session != null) {
                session.close();
            }
        }
    }

    public static void doSomething() {
        CountDownLatch cd = new CountDownLatch(8);
        Thread[] threads = new Thread[8];
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        try {
            Random rand = new Random();
            for (int j = 0; j < 8; j++) {
                final int n = j;
                threads[j] = new Thread(() -> {
                    System.out.println("Thread #" + n + " started");
                    for (int i = 0; i < 20000; i++) {
                        boolean updated = false;
                        int randInt = rand.nextInt(40 - 1) + 1;
                        while (!updated) {
                            Session session = factory.getCurrentSession();
                            session.beginTransaction();
                            Item item = session.get(Item.class, (long) randInt);
                            int oldVal = item.getVal();
                            item.setVal(oldVal + 1);
                            try {
                                Thread.sleep(5);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            try {
                                session.getTransaction().commit();
                                updated = true;

                            } catch (OptimisticLockException e) {
                                session.getTransaction().rollback();

                            }
                            session.close();
                        }
                    }
                    System.out.println("Thread #" + n + " finished");
                    cd.countDown();
                });
                threads[j].start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        factory.close();
    }

    public static void countSum() {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Object o = session.createNativeQuery("SELECT SUM(val) FROM items;").getSingleResult();
            System.out.println("Total val count is: " + o);
            session.close();
        }
    }
}
