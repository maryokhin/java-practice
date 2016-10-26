package algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {
    private int[] values;
    private int[] sortedValues;

    @BeforeEach
    void setUp() {
        values = new int[]{1, 10, 33, 41, 5, 0, 10, 17, 78};

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
        assertArrayEquals(sortedValues, Sort.selectionSort(values));
    }

    @Test
    void testMergeSort() {
        assertArrayEquals(sortedValues, Sort.mergeSort(values));
    }

    @Test
    void testQuickSort() {
        assertArrayEquals(sortedValues, Sort.quickSort(values));
    }

    @Test
    void testHeapSort() {
        assertArrayEquals(sortedValues, Sort.heapSort(values));
    }
}
