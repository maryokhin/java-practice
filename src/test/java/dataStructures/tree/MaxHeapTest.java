package dataStructures.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MaxHeapTest {
    private Heap heap;

    @BeforeEach
    public void setUp() {
        heap = new MaxHeap(new int[]{1, 10, 33, 41, 5, -1, 9, 17});
    }

    @Test
    void testGetSize() {
        assertEquals(8, heap.getSize());
    }

    @Test
    void testIsEmpty() {
        assertFalse(heap.isEmpty());
    }

    @Test
    void testInsertPriority() {
        heap.insertPriority(99);
        assertEquals(9, heap.getSize());
        assertEquals(99, heap.getMax());
    }

    @Test
    void testGetMax() {
        assertEquals(41, heap.getMax());
    }

    @Test
    void testExtractMax() {
        assertEquals(41, heap.extractMax());
        assertEquals(33, heap.getMax());
    }

    @Test
    void testRemove() {
        int oldPriority = heap.get(4);
        heap.remove(4);
        assertEquals(7, heap.getSize());
        assertNotEquals(oldPriority, heap.get(4));
    }

    @Test
    void testChangePriority() {
        int oldPriority = heap.get(4);
        heap.changePriority(4, 99);
        assertNotEquals(oldPriority, heap.get(4));
    }

}
