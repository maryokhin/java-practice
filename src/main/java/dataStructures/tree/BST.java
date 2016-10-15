package dataStructures.tree;

// TODO: Implement this
public class BST<E> implements Tree<E> {
    private final E key;
    private Tree left;
    private Tree right;

    public BST(E key) {
        this.key = key;
    }

    @Override
    public void insert(E item) {

    }

    @Override
    public void remove(E item) {

    }

    @Override
    public int getNodeCount() {
        return 0;
    }

    @Override
    public void printNodes() {

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public E getMin() {
        return null;
    }

    @Override
    public E getMax() {
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
    public E getSuccessor() {
        return null;
    }
}