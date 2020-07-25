package com.company.geekbrains.task2;

public class Task {
    public static int sumMatrix(String[][] matrix) throws MyArrayDataException {
        int sum = 0;
        if (!isMatrix4x4(matrix)) {
            throw new MyArraySizeException("Матрица невалидна");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("На позиции [%d][%d] находится не число", i, j));
                }
            }
        }
        return sum;
    }

    private static boolean isMatrix4x4(String[][] matrix) {
        if (matrix.length == 4) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length == 4) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        else {
            return false;
        }
        return true;
    }
}
