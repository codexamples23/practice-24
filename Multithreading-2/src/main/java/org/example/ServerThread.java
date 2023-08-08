package org.example;

public class ServerThread implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // что-то делаем
                System.out.println(Thread.currentThread() + " is doing something");

                Thread.sleep(1000); // делаем что-то очень долгое
            }
        } catch (InterruptedException e) {
            System.out.println(e);
            // Дополнительные операции по завершению работы сервера
            System.out.println(Thread.currentThread() + " interrupted");
            Thread.currentThread().interrupt();
        }

        prepareShutdown();
    }


    private void prepareShutdown() {
        System.out.println("preparing...");
        if (Thread.interrupted()) {
            System.out.println("Thread was interrupted!");
        }
    }
}
