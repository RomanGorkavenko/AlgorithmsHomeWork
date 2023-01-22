package ru.roman.sem1;

import java.util.Arrays;

public class Shift {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = shift(array, 7);
        System.out.println(Arrays.toString(array2));
    }

    public static int[] shift(int[] array, int numberShift) {
        if (array == null || array.length <= 2 || numberShift >= array.length){
            throw new IllegalArgumentException("The array must contain at least 3 elements, the array cannot be empty," +
                    "the number of elements by which the array is shifted must not be greater than or equal" +
                    "to the length of the array.");
        }

        int[] temp = new int[array.length];
        int index = (array.length - numberShift);

        System.arraycopy(array, index, temp, 0, numberShift);
        System.arraycopy(array, 0, temp, numberShift, index);

        return temp;
    }

}
