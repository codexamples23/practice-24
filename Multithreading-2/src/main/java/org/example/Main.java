package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread.interrupted(); // сбрасывает флаг прерывания
        new Thread().interrupt();
        new Thread().isInterrupted(); // не сбрасывает флаг прерывания

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("Sleeping...");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interrupted!");
                    Thread.currentThread().interrupt();
                }
            }
        };

//        Thread t1 = new Thread(r1);
//        t1.start();
//
//        Thread.sleep(2500);
//        t1.interrupt();

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                long x = 0;
                while (!Thread.interrupted() && x < 10000000000L) {
                    if (x % 10000000 == 0) {
                        System.out.println(x);
                    }
                    x++;
                }
                System.out.println(x);
            }
        };
//        Thread t2 = new Thread(r2);
//        t2.start();
//        Thread.sleep(500);
//        t2.interrupt();

        Runnable server = new ServerThread();


        List<Thread> threads = List.of(
                new Thread(new ServerThread()),
                new Thread(new ServerThread()),
                new Thread(new ServerThread()));
        for (Thread thread: threads) {
            thread.start();
        }

        Thread.sleep(3000);

        for (Thread thread: threads) {
            thread.interrupt();
        }
    }


}