package org.example;


import java.util.Random;
import java.util.concurrent.*;

public class Main {
    // поток-демон раз в 5 секунд считает следующее число фиббоначи и выводит его на экран
    // основной поток считывает с консоли число и запускает [это число] потоков-демонов
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        LoggerThread logger = new LoggerThread();
//
//        logger.setDaemon(true);
//        logger.start();
//
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            int x = scanner.nextInt();
//            if (x == 0) {
//                break;
//            }
//            for (int i = 0; i < x; i++) {
//                new FibThread().start();
//            }
//        }

        Callable<Integer> countSomething = () -> {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            return new Random().nextInt();
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(countSomething); // не здесь

        Thread.sleep(1500);
        System.out.println("Main");
        System.out.println(future.get()); // мы будем ждать здесь


        executorService.shutdown();
    }

    // есть два массива (предположительно больших)
    // array1 array2, в них лежат числа. В массиве sum должны оказаться суммы
    /*
    1 2 3 7
    5 2 1 2
    6 4 4 9

    можно написать метод, принимающий аргументы (array1, array2, sum, start, end)

     */
}