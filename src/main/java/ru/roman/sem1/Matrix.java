package ru.roman.sem1;

public class Matrix {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3, 4, 12},
                {1, 2, 3, 5, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        };

        System.out.println("сумму элементов главной диагонали = " + findMatrixDiagonalSum(array));
        System.out.println("сумму элементов главной побочной = " + findMatrixSecondaryDiagonalSum(array));
    }

    public static int findMatrixDiagonalSum(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int findMatrixSecondaryDiagonalSum(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return -1;
        }
        int sum = 0;
        int endIndex = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[endIndex][i];
            endIndex--;
        }
        return sum;
    }

}
