package algorithms;

class Sort {
    private Sort() {}

    public static int[] bubbleSort(int[] array) {
        return null;
    }

    /**
     * While this sorting algorithm is impractical for large arrays, it is one of the fastest sorting algorithms
     * for very small arrays (n <= 10), faster than even quicksort.
     * <p>
     * Best case: O(n) if array is already sorted.
     * Average case: O(n^2).
     * Worst case: O(n^2) if arrays is sorted in reverse order.
     */
    static int[] insertionSort(int[] array) {
        // go through the whole array and put smaller values in the beginning
        for (int i = 1; i < array.length; i++) {
            // swap values from right to left
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                int temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
            }
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        return null;
    }
}
