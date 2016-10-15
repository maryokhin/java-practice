package algorithms;

class Search {
    private Search() {}

    private static int getHalfPoint(int min, int max) {
        return (int) Math.floor((min + max) / 2);
    }

    /**
     * Iterative binary search: O(log(n)).
     */
    static int binarySearch(int[] values, int searchValue) {
        int min = 0;
        int max = values.length - 1;

        int halfPoint = getHalfPoint(min, max);

        while (min <= max) {
            int lookupValue = values[halfPoint];

            if (lookupValue == searchValue) {
                return halfPoint;
            } else if (lookupValue < searchValue) {
                min = halfPoint + 1;
            } else {
                max = halfPoint - 1;
            }
            halfPoint = getHalfPoint(min, max);
        }

        return -1;
    }

    private static int findIndex(int[] values, int searchValue, int min, int max) {
        int halfPoint = getHalfPoint(min, max);

        if (min >= max) {
            return -1;
        }

        int lookupValue = values[halfPoint];

        if (lookupValue == searchValue) {
            return halfPoint;
        } else if (lookupValue < searchValue) {
            min = halfPoint + 1;
        } else {
            max = halfPoint - 1;
        }
        return findIndex(values, searchValue, min, max);
    }

    /**
     * Recursive version of the binary search, also: O(log(n)).
     */
    static int binarySearchRecursive(int[] values, int searchValue) {
        return findIndex(values, searchValue, 0, values.length - 1);
    }
}
