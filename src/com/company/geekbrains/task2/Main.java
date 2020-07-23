package com.company.geekbrains.task2;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(Task.sumMatrix(
                    new String[][]{{"1", "1", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}}));
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
    }
}
