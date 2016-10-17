package algorithms;

class Fibonacci {
    private Fibonacci() {}

    static int[] createFibonacciSequence(int n) {
        if (n == 1 || n == 2) {
            return new int[]{1};
        }

        int[] seq = new int[n];
        seq[0] = 0;
        seq[1] = 1;

        for (int i = 2; i < n; i++) {
            seq[i] = seq[i - 1] + seq[i - 2];
        }
        return seq;
    }

    static int[] createRecursiveFibonacciSequence(int n) {
        int[] seq = new int[n];

        for (int i = 1; i < n; i++) {
            seq[i] = fibonacciNumber(i);
        }
        return seq;
    }

    private static int fibonacciNumber(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacciNumber(n - 2) + fibonacciNumber(n - 1);
    }
}
