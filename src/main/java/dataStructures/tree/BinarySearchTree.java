package dataStructures.tree;

import java.util.Arrays;
import java.util.function.Consumer;

// TODO: Implement this
class BinarySearchTree<V extends Comparable<V>> implements Tree<V> {
    private Node root;

    private class Node {
        private V value;
        private Node left;
        private Node right;

        private Node(V value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private Node(V value, Node left) {
            this(value, left, null);
        }

        private Node(V value) {
            this(value, null, null);
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    @SafeVarargs
    public BinarySearchTree(V... values) {
        Arrays.stream(values).forEach(this::insert);
    }

    @Override
    public void insert(V value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    /**
     * Recursively follow the nodes of the tree until we find an insertion point.
     * In this definition of the tree, duplicate values are simply ignored.
     */
    private void insert(Node node, V value) {
        int result = value.compareTo(node.value);

        if (result < 0) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        }
        if (result > 0) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    @Override
    public void remove(V value) {

    }

    @Override
    public int getNodeCount() {
        return 0;
    }


    @Override
    public void printNodes() {
        if (root != null) {
            visit(root, System.out::println);
        }
    }

    /**
     * Need to perform a DFS in-order traversal of all the nodes.
     * By accepting a consumer we can execute any lambda function on each visited node.
     */
    private void visit(Node node, Consumer<Node> consumer) {
        if (node == null) {
            return;
        }
        visit(node.left, consumer);
        consumer.accept(node);
        visit(node.right, consumer);
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public V getMin() {
        return null;
    }

    @Override
    public V getMax() {
        return null;
    }

    @Override
    public boolean isInTree() {
        return false;
    }

    @Override
    public boolean isBinarySearchTree() {
        return false;
    }

    @Override
    public V getSuccessor() {
        return null;
    }
}