package dataStructures.queue;

class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        private final E item;
        private Node next;

        private Node(E item) {
            this.item = item;
        }
    }

    private Node head;
    private Node tail;

    @Override
    public void enqueue(E item) {
        if (tail == null) {
            tail = new Node(item);
        } else {
            Node node = new Node(item);
            tail.next = node;
            tail = node;
        }

        // if it's the first element, set head also
        if (head == null) {
            head = tail;
        }
    }

    @Override
    public E dequeue() {
        // remove at head
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        head = node.next;
        return node.item;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
