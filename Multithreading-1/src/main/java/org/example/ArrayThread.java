package org.example;

import java.util.Random;

public class ArrayThread extends Thread {

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


        // запустить потоки

    }

    public ArrayThread(int[] array1, int[] array2, int[] sum, int start, int end) {
        this.array1 = array1;
        this.array2 = array2;
        this.sum = sum;
        this.start = start;
        this.end = end;
    }

    // нужно написать run
    @Override
    public void run() {

    }


}
