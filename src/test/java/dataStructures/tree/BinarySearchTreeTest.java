package dataStructures.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TODO: Implement tests
public class BinarySearchTreeTest {
    private Tree<Integer> tree;

    @BeforeEach
    public void setUp() {
        tree = new BinarySearchTree<>(1, 10, 33, 41, 5, -1, 9, 17);
    }

    @Test
    void testPrint() {
        tree.printNodes();
    }
}
