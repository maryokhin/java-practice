package dataStructures.tree;

/**
 * A heap can be implemented with an array starting at either index 0 or index 1.
 * Most academic heap implementations skip index 0, because the access operations are a bit easier to remember and
 * 1-based indexing has the advantage of the operations being optimized with bitwise operations.
 */
public class MaxHeap implements Heap {
    private final int[] heap;
    private final int maxSize;
    private int size;

    // creates an empty heap
    private MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize + 1];  // we won't use index 0, so need +1 space
    }

    public MaxHeap(int[] sourceArray) {
        this(sourceArray.length * 2);
        this.size = sourceArray.length;
        buildHeap(sourceArray);
    }

    private void buildHeap(int[] sourceArray) {
        System.arraycopy(sourceArray, 0, heap, 1, sourceArray.length);

        // in reverse order go through half the heap and sift down
        // this will be enough to form the whole heap
        // as a side-effect it is not stable, might potentially form different heaps every time
        for (int i = heap.length / 2; i > 0; i--) {
            siftDown(i);
        }
    }

    private void swap(int sourceIndex, int targetIndex) {
        int temp = heap[sourceIndex];
        heap[sourceIndex] = heap[targetIndex];
        heap[targetIndex] = temp;
    }

    private void siftUp(int index) {
        int parentIndex = index / 2;

        if (index > 1 && heap[index] > parentIndex) {
            // swap with parent, keep sifting up
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    private void siftDown(int index) {
        int maxIndex = index;
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;

        // check if left child exists and is bigger than current node
        if (leftIndex <= size && heap[leftIndex] > heap[maxIndex]) {
            maxIndex = leftIndex;
        }
        // check if right child exists and is bigger than current node
        if (rightIndex <= size && heap[rightIndex] > heap[maxIndex]) {
            maxIndex = rightIndex;
        }

        // check if current node not the biggest
        if (index != maxIndex) {
            // swap for bigger child, keep sifting down
            swap(index, maxIndex);
            siftDown(maxIndex);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insertPriority(int priority) {
        // heap is full
        if (size == maxSize) {
            throw new IndexOutOfBoundsException();
        }
        heap[++size] = priority;  // insert at very bottom
        siftUp(size);  // sift up until node reaches it's place

    }

    @Override
    public int get(int index) {
        return heap[index];
    }

    @Override
    public int getMax() {
        return heap[1];
    }

    @Override
    public int extractMax() {
        int max = getMax();
        heap[1] = heap[size]; // swap root with a leaf node
        size--;
        siftDown(1);
        return max;
    }

    @Override
    public void remove(int index) {
        heap[index] = Integer.MAX_VALUE;
        siftUp(index); // sift up the value until it's root
        extractMax(); // extract the fake root
    }

    @Override
    public void changePriority(int index, int priority) {
        int oldPriority = heap[index];
        heap[index] = priority;

        if (priority > oldPriority) {
            siftUp(index);
        } else {
            siftDown(index);
        }
    }

    public int[] heapSort() {
        int oldSize = size;
        int[] result = new int[oldSize];

        for (int i = size; i > 1; i--) {
            swap(1, i);
            size--;
            siftDown(1);
        }
        System.arraycopy(heap, 1, result, 0, oldSize);
        return result;
    }
}
