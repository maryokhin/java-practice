package dataStructures.tree;

public interface Heap {
    int getSize();

    boolean isEmpty();

    void insertPriority(int priority);

    int get(int index);

    int getMax();

    int extractMax();

    void remove(int index);

    void changePriority(int index, int priority);

    int[] heapSort();
}
