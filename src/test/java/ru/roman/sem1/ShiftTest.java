package ru.roman.sem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShiftTest {

    @Test
    void shiftNullArray() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Shift.shift(null, 1));

        assertEquals("The array must contain at least 3 elements, the array cannot be empty," +
                "the number of elements by which the array is shifted must not be greater than or equal" +
                "to the length of the array.", exception.getMessage());
    }

    @Test
    void shiftArraySmaller() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Shift.shift(new int[2], 1));

        assertEquals("The array must contain at least 3 elements, the array cannot be empty," +
                "the number of elements by which the array is shifted must not be greater than or equal" +
                "to the length of the array.", exception.getMessage());
    }

    @Test
    void shiftNumberShiftNotCorrect() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Shift.shift(new int[5], 5));

        assertEquals("The array must contain at least 3 elements, the array cannot be empty," +
                "the number of elements by which the array is shifted must not be greater than or equal" +
                "to the length of the array.", exception.getMessage());
    }

    @Test
    void shift() {
        int[] array = Shift.shift(new int[]{1, 2, 3, 4, 5}, 1);

        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, array);
    }
}