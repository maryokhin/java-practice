package dataStructures.queue;

class ArrayQueue<E> implements Queue<E> {
    private final E[] queue;
    private final int capacity;
    private int read = -1;
    private int write = -1;

    @SuppressWarnings("unchecked")
    ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be less than or equal to zero.");
        }
        this.capacity = capacity;
        this.queue = (E[]) new Object[capacity];
    }

    @Override
    public void enqueue(E item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException();
        } else if (isEmpty()) {
            write = read = 0;
        } else {
            write = (write + 1) % capacity;
        }
        queue[write] = item;
    }

    @Override
    public E dequeue() {
        E item = queue[read];

        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else if (read == write) {
            read = write = -1;
        } else {
            read = (read + 1) % capacity;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return read == -1 && write == -1;
    }

    @Override
    public boolean isFull() {
        return (write + 1) % capacity == read;
    }
}