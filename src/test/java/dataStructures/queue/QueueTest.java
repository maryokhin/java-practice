package dataStructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueTest {
    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new LinkedListQueue<>();
    }

    @Test
    void testEnqueue() {
        queue.enqueue(17);
        assertEquals(17, (int) queue.dequeue());
    }

    @Test
    void testDequeue() {
        queue.enqueue(17);
        assertEquals(17, (int) queue.dequeue());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }
}
