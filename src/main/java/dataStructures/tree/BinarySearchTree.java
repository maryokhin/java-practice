package dataStructures.tree;

import java.util.Arrays;
import java.util.function.Consumer;

class BinarySearchTree<K extends Comparable<K>> implements Tree<K> {
    private final K min;
    private final K max;
    private Node root;

    private class Node {
        private K key;
        private Node left;
        private Node right;

        private Node(K key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }

    @SafeVarargs
    BinarySearchTree(K min, K max, K... keys) {
        this.min = min;
        this.max = max;
        Arrays.stream(keys).forEach(this::insert);
    }

    @Override
    public void insert(K key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(root, key);
        }
    }

    /**
     * Recursively follow the nodes of the tree until we find an insertion point.
     * In this definition of the tree, duplicate keys are simply ignored.
     * <p>
     * This is an O(h) operation, where h = height of the tree.
     */
    private void insert(Node node, K key) {
        int result = key.compareTo(node.key);

        if (result < 0) {
            if (node.left == null) {
                node.left = new Node(key);
            } else {
                insert(node.left, key);
            }
        }
        if (result > 0) {
            if (node.right == null) {
                node.right = new Node(key);
            } else {
                insert(node.right, key);
            }
        }
    }

    @Override
    public boolean remove(K key) {
        return deleteNode(null, root, key);
    }

    private boolean deleteNode(Node parent, Node node, K key) {
        if (node == null) return false; // reached end of tree, key not found

        int result = key.compareTo(node.key);

        // go left/right in tree to find the node
        if (result < 0) return deleteNode(node, node.left, key);
        else if (result > 0) return deleteNode(node, node.right, key);

        else { // found the node to delete
            // case 1: two children
            if (node.left != null && node.right != null) {
                node.key = findMin(node.right).key;
                deleteNode(node, node.right, node.key);
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
        int count = 0;

        if (root != null) {
            count = getTreeCount(root);
        }
        return count;
    }

    private int getTreeCount(Node node) {
        int count = 1; // count the node

        // count the subtrees
        if (node.left != null) {
            count += getTreeCount(node.left);
        }
        if (node.right != null) {
            count += getTreeCount(node.right);
        }
        return count;
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
    public K getMin() {
        if (root == null) {
            return null;
        }
        return findMin(root).key;
    }

    private Node findMin(Node node) {
        if (node.left != null) {
            return findMin(node.left);
        }
        return node;
    }

    @Override
    public K getMax() {
        if (root == null) {
            return null;
        }
        return findMax(root).key;
    }

    private Node findMax(Node node) {
        if (node.right != null) {
            return findMax(node.right);
        }
        return node;
    }


    @Override
    public boolean isInTree(K key) {
        return root != null && findNode(root, key) != null;
    }

    /**
     * Recursive algorithm to find the node with the key in the tree: O(n).
     */
    private Node findNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        int result = key.compareTo(node.key);

        if (result == 0) {
            return node;
        } else if (result < 0) {
            return findNode(node.left, key);
        } else {
            return findNode(node.right, key);
        }
    }

    @Override
    public boolean isBinarySearchTree() {
        return isValidNode(root, this.min, this.max);
    }

    private boolean isValidNode(Node node, K min, K max) {
        if (node == null) {
            return true;
        }
        boolean nodeValid = !(min.compareTo(node.key) >= 0 || max.compareTo(node.key) <= 0);
        return nodeValid && isValidNode(node.left, min, node.key) && isValidNode(node.right, node.key, max);
    }

    @Override
    public K getSuccessor(K key) {
        Node parent = null;
        Node currentNode = root;
        Node node = null;

        // find the node and it's parent
        while (currentNode != null) {
            parent = currentNode;

            int result = key.compareTo(currentNode.key);

            if (result == 0) {
                node = currentNode;
                break;
            } else if (result < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        // found the node
        if (node != null) {
            if (node.right != null) {
                return findMin(node.right).key;
            } else {
                return parent.key;
            }
        }
        return null;
    }
}