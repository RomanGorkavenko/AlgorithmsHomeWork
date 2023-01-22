package ru.roman.sem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void notSquareMatrix() {
        int notSquare = Matrix.findMatrixDiagonalSum(new int[][]{
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        });

        assertEquals(-1, notSquare);
    }
    @Test
    void notSquareMatrixSecondary() {
        int notSquare = Matrix.findMatrixSecondaryDiagonalSum(new int[][]{
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        });

        assertEquals(-1, notSquare);
    }

    @Test
    void findMatrixDiagonalSum() {
        int sum = Matrix.findMatrixDiagonalSum(new int[][]{
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5}
        });

        assertEquals(15, sum);
    }

    @Test
    void findMatrixSecondaryDiagonalSum() {
        int sum = Matrix.findMatrixSecondaryDiagonalSum(new int[][]{
                {1, 2, 3, 4, 6},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {1, 4, 3, 4, 5},
                {1, 2, 3, 4, 5}
        });

        assertEquals(18, sum);
    }
}