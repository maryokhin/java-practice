package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FibonacciTest {
    @Test
    void testFibonacciSequence() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8}, Fibonacci.createFibonacciSequence(7));
    }

    @Test
    void testRecursiveFibonacciSequence() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8}, Fibonacci.createRecursiveFibonacciSequence(7));
    }
}
