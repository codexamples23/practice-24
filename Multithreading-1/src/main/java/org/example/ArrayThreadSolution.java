package org.example;

import java.util.Random;

public class ArrayThreadSolution extends Thread {

    private int[] array1;
    private int[] array2;
    private int[] sum;
    private int start;
    private int end;

    public static void main(String[] args) {
        int size = 1000000;
        int[] array1 = new int[size];
        int[] array2 = new int[size];
        int[] sum = new int[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array1[i] = random.nextInt(100);
            array2[i] = random.nextInt(100);
        }

        // создать потоки
        ArrayThreadSolution thread1 = new ArrayThreadSolution(array1, array2, sum, 0, size / 2);
        ArrayThreadSolution thread2 = new ArrayThreadSolution(array1, array2, sum, size / 2, size);

        // запустить потоки
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayThreadSolution(int[] array1, int[] array2, int[] sum, int start, int end) {
        this.array1 = array1;
        this.array2 = array2;
        this.sum = sum;
        this.start = start;
        this.end = end;
    }

    // нужно написать run
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum[i] = array1[i] + array2[i];
        }
    }


}
