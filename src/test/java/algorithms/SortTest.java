package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {
    private int[] values;
    private int[] sortedValues;

    @BeforeEach
    void setUp() {
        values = new int[]{1, 10, 33, 41, 5, -1, 10, 17};

        //sort a copy of the array to compare to
        sortedValues = Arrays.copyOf(values, values.length);
        Arrays.sort(sortedValues);

    }

    @Test
    void testBubbleSort() {
        assertArrayEquals(sortedValues, Sort.bubbleSort(values));
    }

    @Test
    void testInsertionSort() {
        assertArrayEquals(sortedValues, Sort.insertionSort(values));
    }

    @Test
    void testSelectionSort() {
        assertEquals(sortedValues, Sort.selectionSort(values));
    }

    @Test
    void testMergeSort() {
        assertEquals(sortedValues, Sort.mergeSort(values));
    }

    @Test
    void testQuickSort() {
        assertEquals(sortedValues, Sort.quickSort(values));
    }
}
