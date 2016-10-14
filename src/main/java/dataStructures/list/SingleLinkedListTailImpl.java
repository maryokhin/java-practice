package dataStructures.list;

import java.util.Arrays;

public class SingleLinkedListTailImpl<E> implements List<E> {
    private class Node {
        private E item;
        private Node next;

        private Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }

        private Node(E item) {
            this(item, null);
        }
    }

    private Node head;
    private Node tail;

    private int size;

    @SafeVarargs
    public SingleLinkedListTailImpl(E... items) {
        Arrays.asList(items).forEach(this::append);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // tail optimization
        if (index == size - 1) {
            return tail.item;
        }

        Node currentNode = head;
        int nodeIndex = 0;

        // else expensive iteration
        while (nodeIndex != index) {
            currentNode = currentNode.next;
            nodeIndex++;
        }

        return currentNode.item;
    }

    @Override
    public E getFromEnd(int index) {
        int targetIndex = size - index;
        return get(targetIndex); // will throw exception if index -> targetIndex is wrong
    }

    @Override
    public void prepend(E item) {
        Node newNode = new Node(item, head);

        if (size == 1) {
            head = tail = newNode;
        } else {
            head = newNode;
        }
        size++;
    }

    @Override
    public void append(E item) {
        Node newNode = new Node(item);

        // always link the tail if present
        if (tail != null) {
            tail.next = newNode;
        }
        //set the new tail
        tail = newNode;
        size++;

        // update head to new tail
        if (size == 1) {
            head = tail;
        }
    }

    @Override
    public void insert(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == 1) {
            head = tail = new Node(item);
        } else {
            int nodeIndex = 0;
            Node previousNode = null;
            Node currentNode = head;

            // navigate to the node at index
            while (nodeIndex != index) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                nodeIndex++;
            }

            // inserting the head
            if (previousNode == null) {
                head = new Node(item, head.next);
            }
            // inserting the tail
            else if (currentNode.next == null) {
                Node node = new Node(item);
                previousNode.next = node;
                tail = node;
            } else { // inserting into the middle
                previousNode.next = new Node(item, currentNode.next);
            }
        }
        size++;
    }

    @Override
    public E pop() {
        if (tail == null) {
            throw new IndexOutOfBoundsException();
        }
        Node previousNode = null;
        Node currentNode = head;

        // navigate to the last node
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        Node node = tail;
        tail = previousNode;
        size--;

        // also update the head if needed
        if (size == 1) {
            head = tail;
        }
        return node.item;
    }

    @Override
    public E popFront() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        head = head.next;
        size--;
        return node.item;
    }

    @Override
    public E getFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        return head.item;
    }

    @Override
    public E getLast() {
        if (tail == null) {
            throw new IndexOutOfBoundsException();
        }
        return tail.item;
    }

    @Override
    public void remove(E item) {
        Node previousNode = null;
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.item.equals(item)) {
                // not the head node
                if (previousNode != null) {
                    previousNode.next = currentNode.next;
                }
                // reset head if needed
                if (currentNode == head) {
                    head = currentNode.next;
                }
                // reset tail if needed
                if (currentNode == tail) {
                    tail = previousNode;
                }
                size--;
            }
            // advance the nodes
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node previousNode = null;
        Node currentNode = head;
        int nodeIndex = 0;

        while (nodeIndex != index) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            nodeIndex++;
        }

        if (previousNode != null) {
            previousNode.next = currentNode.next;
        }
        // reset head if needed
        if (currentNode == head) {
            head = currentNode.next;
        }
        // reset tail if needed
        if (currentNode == tail) {
            tail = previousNode;
        }
        size--;
    }

    @Override
    public int findIndex(E item) {
        Node currentNode = head;
        int nodeIndex = 0;

        // try to find the first match
        while (currentNode != null) {
            if (currentNode.item.equals(item)) {
                return nodeIndex;
            }
            currentNode = currentNode.next;
            nodeIndex++;
        }

        return -1;
    }

    @Override
    public void reverse() {
        Node reverseNode = null;
        Node currentNode = head;

        // iterate nodes in one direction and link in reverse direction
        while (currentNode != null) {
            Node nextNode = currentNode.next;  // set next node
            currentNode.next = reverseNode; // add reverse link
            reverseNode = currentNode; // advance reverse node
            currentNode = nextNode; // advance current node
        }
        tail = head;
        head = reverseNode;
    }
}
