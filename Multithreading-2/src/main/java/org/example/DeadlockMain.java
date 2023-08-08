package org.example;

public class DeadlockMain {
    public static void main(String[] args) throws InterruptedException {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread());
                System.out.println("lock1 acquired");
                synchronized (lock2) {
                    System.out.println(Thread.currentThread());
                    System.out.println("lock2 acquired");
                }
                System.out.println("lock2 released");
            }
            System.out.println("lock1 released");
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread());
                System.out.println("lock2 acquired");
                synchronized (lock1) {
                    System.out.println(Thread.currentThread());
                    System.out.println("lock1 acquired");
                }
                System.out.println("lock1 released");
            }
            System.out.println("lock2 released");
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
