package ru.roman.sem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    void fibonacciNumber() {
        int numberFib = Fibonacci.fibonacci(13);

        Assertions.assertEquals(144, numberFib);
    }

    @Test
    void fibonacciLinearNumber() {
        int numberFib = Fibonacci.fibonacciLinear(13);

        Assertions.assertEquals(144, numberFib);
    }
}