package org.example;

public class LivelockMain {
    public static class IncrementNumber {
        private int x = 0;

        public IncrementNumber(int x) {
            this.x = x;
        }

        public void incr() {
            x++;
        }

        public void decr() {
            x--;
        }

        public int getX() {
            return x;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IncrementNumber x = new IncrementNumber(0);

        Thread thread1 = new Thread(() -> {
            do {
                x.incr();
                try { Thread.sleep(10); } catch (InterruptedException e) {}
                // int tmpX = x.getX(); можно сохранить значение в отдельную переменную
                // происходит "состояние гонки", и мы можем вывести -1
                if (x.getX() % 10 == 0) {
                    System.out.println(Thread.currentThread() + " " + x.getX());
                }
            } while (x.getX() < 100);
            System.out.println(x.getX());
        });
        Thread thread2 = new Thread(() -> {
            do {
                x.decr();
                try { Thread.sleep(10); } catch (InterruptedException e) {}
                // происходит "состояние гонки", и мы можем вывести 1
                if (x.getX() % 10 == 0) {
                    System.out.println(Thread.currentThread() + " " + x.getX());
                }
            } while (x.getX() > -100);
            System.out.println(x.getX());

        });

        thread1.start();
        thread2.start();
//        thread1.run();
//        thread2.run();

        thread1.join();
        thread2.join();
    }
}
