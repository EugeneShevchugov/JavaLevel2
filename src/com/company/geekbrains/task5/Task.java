package com.company.geekbrains.task5;

import java.util.Arrays;

public class Task extends Thread {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void firstTask() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        editArray(arr);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void secondTask() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                editArray(a1);
            }
        });
        first.start();

        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                editArray(a2);
            }
        });
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void editArray(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
