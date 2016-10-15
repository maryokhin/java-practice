package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    private int[] values;

    @BeforeEach
    void setUp() {
        values = new int[]{-1, 1, 5, 9, 10, 17, 33, 41};
    }

    @Test
    void testBinarySearch() {
        assertEquals(2, Search.binarySearch(values, 5));
    }

    @Test
    void testInvalidBinarySearch() {
        assertEquals(-1, Search.binarySearch(values, 111));
    }

    @Test
    void testBinarySearchRecursive() {
        assertEquals(3, Search.binarySearchRecursive(values, 9));
    }

    @Test
    void testInvalidBinarySearchRecursive() {
        assertEquals(-1, Search.binarySearchRecursive(values, 111));
    }
}
