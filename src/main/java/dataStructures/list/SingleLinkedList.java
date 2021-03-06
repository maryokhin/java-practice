package dataStructures.list;

import java.util.Arrays;

public class SingleLinkedList<E> implements List<E> {
    private class Node {
        E item;
        Node next;

        private Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }

        private Node(E item) {
            this(item, null);
        }
    }

    @SafeVarargs
    public SingleLinkedList(E... items) {
        Arrays.asList(items).forEach(this::append);
    }

    private Node head;
    private int size;

    /**
     * Always constant-time because it's a precomputed value: O(1).
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Always constant-time because it depends on a precomputed value: O(1).
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Because we need go through all the nodes in the list: O(n).
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int nodeIndex = 0;
        Node node = head;

        // go through all the nodes until we reach the node at index
        while (nodeIndex != index) {
            node = node.next;
            nodeIndex++;
        }
        return node.item;
    }

    @Override
    public E getFromEnd(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int targetIndex = size - index;
        return get(targetIndex);
    }

    /**
     * Constant-time because we maintain reference to the head: O(1).
     */
    @Override
    public void prepend(E item) {
        if (head == null) {
            head = new Node(item);
        } else {
            head = new Node(item, head);
        }
        size++;
    }

    /**
     * Because we need to go through all the nodes in the list: O(n).
     */
    @Override
    public void append(E item) {
        Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
        } else {
            Node currentNode = head;

            // go through all the nodes until we reach the tail
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    @Override
    public void insert(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int nodeIndex = 0;
        Node previousNode = null;
        Node currentNode = head;

        while (nodeIndex != index) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            nodeIndex++;
        }

        Node newNode = new Node(item, currentNode);

        // not head node
        if (previousNode != null) {
            previousNode.next = newNode;
        } else {
            head = newNode;
        }
    }

    /**
     * Because we need to go through all the nodes to get to the tail: O(n).
     */
    @Override
    public E pop() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        Node previousNode = null;
        Node node = head;

        // go through all the nodes until we reach the last one
        while (node.next != null) {
            previousNode = node;
            node = node.next;
        }

        // if it's not he head node
        if (previousNode != null) {
            previousNode.next = null;
        } else {
            head = null;
        }
        size--;
        return node.item;
    }

    /**
     * Constant-time because we maintain reference to the head: O(1).
     */
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

    /**
     * Constant-time because we maintain reference to the head: O(1).
     */
    @Override
    public E getFirst() {
        return head != null ? head.item : null;
    }

    /**
     * Because we need to go through all the nodes to get to the tail: O(n).
     */
    @Override
    public E getLast() {
        if (head == null) {
            return null;
        }
        Node tail = head;

        // go through all the nodes until we reach the tail
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail.item;
    }

    /**
     * Because we need to go through all the nodes to find the node: O(n).
     */
    @Override
    public void remove(E item) {
        Node previousNode = null;
        Node currentNode = head;

        while (currentNode != null) {
            // found a node that needs to be removed
            if (currentNode.item.equals(item)) {
                // not the head node
                if (previousNode != null) {
                    previousNode.next = currentNode.next;
                } else {
                    // bump the head node
                    head = currentNode.next;
                }
                size--;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    /**
     * Because we need to go through all the nodes to find the node: O(n).
     */
    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int nodeIndex = 0;
        Node previousNode = null;
        Node currentNode = head;

        while (nodeIndex != index) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            nodeIndex++;
        }

        if (previousNode != null) {
            previousNode.next = currentNode.next;
        } else {
            head = currentNode.next;
        }
        size--;
    }

    /**
     * Because we need to go through all the nodes: O(n).
     */
    @Override
    public int findIndex(E item) {
        int nodeIndex = 0;
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.item.equals(item)) {
                return nodeIndex;
            }
            currentNode = currentNode.next;
            nodeIndex++;
        }
        return -1;
    }

    /**
     * Because we need to repoint links for all the nodes: O(n).
     */
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
        head = reverseNode;
    }
}