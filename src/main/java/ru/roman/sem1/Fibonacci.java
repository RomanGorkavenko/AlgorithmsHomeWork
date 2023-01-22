package ru.roman.sem1;

public class Fibonacci {

    public static int fibonacci(int position) {
        if (position == 1) {
            return 0;
        }
        if (position == 2) {
            return 1;
        }
        return fibonacci(position - 1) + fibonacci(position - 2);
    }

    public static int fibonacciLinear(int position) {
        int[] numberFib = new int[position];
        if (position == 1){
            numberFib[0] = 0;
            return numberFib[0];
        }
        numberFib[1] = 1;
        for (int i = 2; i < numberFib.length; i++) {
            numberFib[i] = numberFib[i - 1] + numberFib[i - 2];
        }
        return numberFib[position - 1];
    }

}
