package algorithms;

class Sort {
    private Sort() {}

    /**
     * This sorting algorithm is pretty bad no matter how you look at it.
     * It only "works" for really small inputs (n<=16) and even then something like insertion sort is much better.
     * <p>
     * Best case: O(n) if array is already sorted.
     * Average case: O(n^2).
     * Worst case: O(n^2) if array is sorted in reverse order.
     */
    static int[] bubbleSort(int[] array) {
        // go through the elements until they don't need to be swapped anymore
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;

            // swap elements from left to right
            for (int j = 0; j < array.length - 1; j++) {
                // swap each right with left if right is bigger
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            //
            if (!swapped) break;
        }
        return array;
    }

    /**
     * While this sorting algorithm is impractical for large arrays, it is one of the fastest sorting algorithms
     * for very small arrays (n <= 10), faster than even quicksort.
     * <p>
     * Best case: O(n) if array is already sorted.
     * Average case: O(n^2).
     * Worst case: O(n^2) if array is sorted in reverse order.
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

    /**
     * Similar to bubble sort, selection sort is mostly a weaker algorithm on small arrays, compared to insertion sort,
     * and useless on big arrays. It also has a downside that it doesn't have detection of an already sorted input array.
     * <p>
     * Best case: O(n^2) even if array is already sorted.
     * Average case: O(n^2).
     * Worst case: O(n^2).
     */
    static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            // find the smallest element in the remaining elements (left to right)
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            // swap the current element with the smallest one
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }

    static int[] mergeSort(int[] array) {
        return array;
    }

    static int[] quickSort(int[] array) {
        return array;
    }
}
