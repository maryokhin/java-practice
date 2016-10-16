package dataStructures.tree;

/**
 * Interface for implementing a binary search tree.
 *
 * @param <K> type of key that the tree will contain. Keys *must* be sortable to be stored in the tree.
 */
interface Tree<K extends Comparable<K>> {
    /**
     * Insert key into the tree.
     *
     * @param key key to insert into the tree.
     */
    void insert(K key);

    /**
     * Removes key from the tree.
     *
     * @param key key to remove from the tree.
     * @return true if a node was removed, false otherwise.
     */
    boolean remove(K key);

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes.
     */
    int getNodeCount();

    /**
     * Prints the keys of all the nodes, from min to max.
     */
    void printNodes();

    /**
     * Returns the height in nodes (single node's height is 1).
     *
     * @return height of the tree.
     */
    int getHeight();

    /**
     * Returns the minimum key stored in the tree.
     *
     * @return minimum key stored in the tree.
     */
    K getMin();

    /**
     * Returns the maximum key stored in the tree.
     *
     * @return maximum key stored in the tree.
     */
    K getMax();

    /**
     * Checks if the key is in the tree or not.
     *
     * @param key key to find in the tree.
     * @return true if the key is in the tree, false otherwise.
     */
    boolean isInTree(K key);

    /**
     * Checks if the binary tree is a binary search tree or not.
     *
     * @return true if it is a binary search tree, false otherwise.
     */
    boolean isBinarySearchTree();

    /**
     * Returns next highest key in the tree after given key, null if none.
     *
     * @param key key to find the successor for.
     * @return key of the successor or null.
     */
    K getSuccessor(K key);
}