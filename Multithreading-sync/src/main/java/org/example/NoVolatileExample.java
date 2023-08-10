package org.example;

public class NoVolatileExample {

    public static class Value {
        private volatile int value;

        public int getValue() {
            return value;
        }

//        public int complicatedGetValue() {
//            int x = value;
//            System.out.println(x);
//            return x;
//        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static int sharedCounter = 0;

    public static void main(String[] args) {
        Thread readerThread = new Thread(() -> {
            int localCounter = 0;
            while (true) {
                if (localCounter != sharedCounter) {
                    localCounter = sharedCounter;
                    System.out.println("Read value: " + sharedCounter);
                }
            }
        });
        readerThread.setDaemon(true);

        Thread updaterThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedCounter++;
                System.out.println("Updated value to: " + sharedCounter);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Немного ждём
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        readerThread.start();
        updaterThread.start();


    }
}
