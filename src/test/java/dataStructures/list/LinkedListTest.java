package dataStructures.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LinkedListTest {
    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SingleLinkedListImpl<>(1, 10, 33, 41, 5, -1, 9, 17);
    }

    @Test
    void testSize() {
        assertEquals(8, list.size());
    }

    @Test
    void testIsEmpty() {
        assertEquals(false, list.isEmpty());
    }

    @Test
    void testGet() {
        assertEquals(33, (int) list.get(2));
    }

    @Test
    void testGetFromEnd() {
        assertEquals(9, (int) list.getFromEnd(2));
    }

    @Test
    void testPrepend() {
        list.prepend(0);
        assertEquals(0, (int) list.getFirst());
    }

    @Test
    void testAppend() {
        list.append(0);
        assertEquals(0, (int) list.getLast());
    }

    @Test
    void testInsert() {
        list.insert(2, 111);
        assertEquals(111, (int) list.get(2));
    }

    @Test
    void testPop() {
        assertEquals((int) list.pop(), 17);
        // check that the element was popped out
        assertEquals((int) list.getLast(), 9);
    }

    @Test
    void testPopFront() {
        assertEquals(1, (int) list.popFront());
        // check that the element was popped out
        assertEquals(10, (int) list.getFirst());
    }

    @Test
    void testGetFirst() {
        assertEquals(1, (int) list.getFirst());
    }

    @Test
    void testGetLast() {
        assertEquals((int) list.getLast(), 17);
    }

    @Test
    void testRemove() {
        list.remove(17);
        assertEquals(7, list.size());
        // check that the element was removed
        assertEquals(9, (int) list.getLast());
    }

    @Test
    void testRemoveAt() {
        list.removeAt(1);
        list.removeAt(0);
        assertEquals(6, list.size());
        assertEquals(33, (int) list.getFirst());
    }

    @Test
    void testFindIndex() {
        assertEquals(2, list.findIndex(33));
    }

    @Test
    void testReverse() {
        list.reverse();
        // check that the length is the same
        assertEquals(8, list.size());
        // check that the end values have been swapped
        assertEquals(17, (int) list.getFirst());
        assertEquals(1, (int) list.getLast());
        // check that one of the middle values was reversed
        assertEquals(5, (int) list.get(3));
    }
}
