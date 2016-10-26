package algorithms;

import dataStructures.tree.MaxHeap;

import java.util.Arrays;

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

    /**
     * Similar to quicksort, mergesort is a divide-and-conquer algorithm that is efficient on large datasets.
     * While in general quicksort outperforms mergesort for RAM-based arrays, mergesort might be a good choice
     * when the dataset is sequential or doesn't allow random access (i.e. linked list) making quicksort impossible.
     * <p>
     * Best case: O(n*log(n)) even if array is sorted in naive implementation. Natural Merge Sort will be O(n).
     * Average case: O(n*log(n)).
     * Worst case: O(n*log(n)).
     */
    static int[] mergeSort(int[] array) {
        if (array.length <= 1) return array;

        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];

        // copy the elements to the halved arrays
        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);

        // sort each half
        mergeSort(first);
        mergeSort(second);

        // merge the sorted halves
        return merge(array, first, second);
    }


    private static int[] merge(int[] result, int[] first, int[] second) {
        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;


        while (firstIndex < first.length && secondIndex < second.length) {
            if (first[firstIndex] < second[secondIndex]) {
                result[resultIndex] = first[firstIndex];
                firstIndex++;
            } else {
                result[resultIndex] = second[secondIndex];
                secondIndex++;
            }
            resultIndex++;
        }

        // copy remaining elements into the resulting array
        System.arraycopy(first, firstIndex, result, resultIndex, first.length - firstIndex);
        System.arraycopy(second, secondIndex, result, resultIndex, second.length - secondIndex);

        return result;
    }

    /**
     * Divide-and-conquer sorting algorithm which is good for large input arrays.
     * Lots of standard libraries use it at the default sorting algorithm, i.e., Java core
     * uses insertion sort if n <= 17 and double-pivot quicksort for n > 17.
     * <p>
     * Best case: O(n*log(n)) if partitions are as evenly balanced as possible.
     * Average case: O(n*log(n)).
     * Worst case: O(n^2) with naive pivot (i.e. always the first element).
     */
    static int[] quickSort(int[] array) {
        return doQuickSort(array, 0, array.length - 1);
    }

    private static int[] doQuickSort(int[] array, int left, int right) {
        int pivot = array[(left + right) / 2];

        int i = left, j = right;

        while (i <= j) {
            // find element that doesn't belong in the left partition
            while (array[i] < pivot) {
                i++;
            }
            // find element that doesn't belong in the right partition
            while (array[j] > pivot) {
                j--;
            }
            // swap elements if it's not the same element
            if (i <= j) {
                // swap the values
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                // advance the partition
                i++;
                j--;
            }
        }

        if (left < j) {
            array = doQuickSort(array, left, j);
        }
        if (i < right) {
            array = doQuickSort(array, i, right);
        }
        return array;
    }

    static int[] heapSort(int[] array) {
        System.out.println(Arrays.toString(array));
        int[] result = new MaxHeap(array).heapSort();
        System.out.println(Arrays.toString(array));
        return result;
    }
}
