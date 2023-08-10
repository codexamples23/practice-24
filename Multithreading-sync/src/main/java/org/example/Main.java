package org.example;

public class Main {
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