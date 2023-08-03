package org.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    private final Object object = new Object();

    public void increment() throws InterruptedException {

        if (lock.tryLock(100, TimeUnit.DAYS)) {
            // try чтобы гарантировать finally
            try {
                count++;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("It is locked for 100 days!");
        }
//        lock.lock();
//        try {
//            count++;
//        } finally {
//            lock.unlock();
//        }
    }

    public int getCount() {
        return count;
    }


//    public void increment() {
//        synchronized (object) {
//            count++;
//        }
//    }
//
//    public int getCount() {
//        synchronized (object) {
//            return count;
//        }
//    }


}
