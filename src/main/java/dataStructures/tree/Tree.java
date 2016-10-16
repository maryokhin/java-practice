package dataStructures.tree;

/**
 * Interface for implementing a binary search tree.
 *
 * @param <V> type of item that the tree will contain. Items *must* be sortable to be stored in the tree.
 */
interface Tree<V extends Comparable<V>> {
    /**
     * Insert value into the tree.
     *
     * @param value value to insert into the tree.
     */
    void insert(V value);

    /**
     * Removes value from the tree.
     *
     * @param value value to remove from the tree.
     */
    void remove(V value);

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes.
     */
    int getNodeCount();

    /**
     * Prints the values of all the nodes, from min to max.
     */
    void printNodes();

    /**
     * Returns the height in nodes (single node's height is 1).
     *
     * @return height of the tree.
     */
    int getHeight();

    /**
     * Returns the minimum value stored in the tree.
     *
     * @return minimum value stored in the tree.
     */
    V getMin();

    /**
     * Returns the maximum value stored in the tree.
     *
     * @return maximum value stored in the tree.
     */
    V getMax();

    /**
     * Checks if the value is in the tree or not.
     *
     * @return true if the value is in the tree, false otherwise.
     */
    boolean isInTree();

    /**
     * Checks if the binary tree is a binary search tree or not.
     *
     * @return true if it is a binary search tree, false otherwise.
     */
    boolean isBinarySearchTree();

    /**
     * Returns next highest value in the tree after given value, null if none.
     *
     * @return value of the successor or null.
     */
    V getSuccessor();
}