package dataStructures.tree;

import java.util.Arrays;
import java.util.function.Consumer;

class BinarySearchTree<V extends Comparable<V>> implements Tree<V> {
    private final V min;
    private final V max;
    private Node root;

    private class Node {
        private V value;
        private Node left;
        private Node right;

        private Node(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    @SafeVarargs
    BinarySearchTree(V min, V max, V... values) {
        this.min = min;
        this.max = max;
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
    public boolean remove(V value) {
        return deleteNode(null, root, value);
    }

    private boolean deleteNode(Node parent, Node node, V value) {
        if (node == null) return false; // reached end of tree, value not found

        int result = value.compareTo(node.value);

        // go left/right in tree to find the node
        if (result < 0) return deleteNode(node, node.left, value);
        else if (result > 0) return deleteNode(node, node.right, value);

        else { // found the node to delete
            // case 1: two children
            if (node.left != null && node.right != null) {
                node.value = findMin(node.right).value;
                deleteNode(node, node.right, node.value);
            }
            // case 2 & 3: one child or no children.
            else if (parent.left.equals(node)) {
                parent.left = (node.left != null) ? node.left : node.right;
            } else if (parent.right.equals(node)) {
                parent.right = (node.left != null) ? node.left : node.right;
            }
            return true;
        }
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
        if (root == null) {
            return -1;
        }
        return getHeight(root);
    }

    /**
     * We could pre-compute the height (int size), but we implement recursive height-calculation for educational purpose.
     * Pre-computed height would be O(ln(n)), calculating it each time will be O(n).
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    @Override
    public V getMin() {
        if (root == null) {
            return null;
        }
        return findMin(root).value;
    }

    private Node findMin(Node node) {
        if (node.left != null) {
            return findMin(node.left);
        }
        return node;
    }

    @Override
    public V getMax() {
        if (root == null) {
            return null;
        }
        return findMax(root).value;
    }

    private Node findMax(Node node) {
        if (node.right != null) {
            return findMax(node.right);
        }
        return node;
    }


    @Override
    public boolean isInTree(V value) {
        return root != null && findNode(root, value) != null;
    }

    /**
     * Recursive algorithm to find the node with the value in the tree: O(n).
     */
    private Node findNode(Node node, V value) {
        if (node == null) {
            return null;
        }
        int result = value.compareTo(node.value);

        if (result == 0) {
            return node;
        } else if (result < 0) {
            return findNode(node.left, value);
        } else {
            return findNode(node.right, value);
        }
    }

    @Override
    public boolean isBinarySearchTree() {
        return isValidNode(root, this.min, this.max);
    }

    private boolean isValidNode(Node node, V min, V max) {
        if (node == null) {
            return true;
        }
        boolean nodeValid = !(min.compareTo(node.value) >= 0 || max.compareTo(node.value) <= 0);
        return nodeValid && isValidNode(node.left, min, node.value) && isValidNode(node.right, node.value, max);
    }

    @Override
    public V getSuccessor() {
        return null;
    }
}