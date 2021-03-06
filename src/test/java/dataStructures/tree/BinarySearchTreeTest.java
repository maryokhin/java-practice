package dataStructures.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private Tree<Integer> tree;

    @BeforeEach
    public void setUp() {
        tree = new BinarySearchTree<>(Integer.MIN_VALUE, Integer.MAX_VALUE, 1, 10, 33, 41, 5, -1, 9, 17);
    }

    @Test
    void testPrint() {
        tree.printNodes();
    }

    @Test
    void testGetHeight() {
        assertEquals(4, tree.getHeight());
    }

    @Test
    void testMin() {
        assertEquals(-1, (int) tree.getMin());
    }

    @Test
    void testMax() {
        assertEquals(41, (int) tree.getMax());
    }

    @Test
    void testIsInTree() {
        assertTrue(tree.isInTree(33));
        assertFalse(tree.isInTree(111));
    }

    @Test
    void testRemoveFromTree() {
        assertTrue(tree.remove(10));
        assertFalse(tree.isInTree(10));
        assertFalse(tree.remove(111));
    }

    @Test
    void testIsBinarySearchTree() {
        assertTrue(tree.isBinarySearchTree());
    }

    @Test
    void testGetSuccessor() {
        assertEquals(41, (int) tree.getSuccessor(33));
    }

    @Test
    void testNodeCount() {
        assertEquals(8, tree.getNodeCount());
    }
}
