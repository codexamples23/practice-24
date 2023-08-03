package org.example;


// поток-демон раз в 5 секунд считает следующее число фиббоначи и выводит его на экран
public class FibThread extends Thread {

    private int prev = 1;
    private int cur = 1;

    public FibThread() {
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            int temp = cur;
            cur = prev + cur;
            prev = temp;
            System.out.println(cur);
            try {
                Thread.sleep(4500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
