package dataStructures.list;

/**
 * Interface for implementing a linked list. It is up to the implementor if to decide if they want to implement
 * a single/double-linked list with/without a tail pointer and with/without sentinel node(s).
 *
 * @param <E> type of item that the list will contain.
 */
public interface LinkedList<E> {
    /**
     * Returns size of the list.
     *
     * @return number of items in the list.
     */
    int size();

    /**
     * Checks if list is empty.
     *
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Get value of item at index.
     *
     * @param index index at which to get the item's value.
     * @return item at index.
     */
    E get(int index);

    /**
     * Gets the value of item at index offset (starting from the end).
     *
     * @param index offset index to find the value.
     * @return value of item at index from end.
     */
    E getFromEnd(int index);

    /**
     * Inserts item at the beginning of the list.
     *
     * @param item item to insert.
     */
    void prepend(E item);

    /**
     * Inserts item at the end of the list.
     *
     * @param item item to insert.
     */
    void append(E item);

    /**
     * Insert item at index.
     *
     * @param index index at which to insert the item.
     * @param item  item to insert.
     */
    void insert(int index, E item);

    /**
     * Remove item from end, return value.
     *
     * @return the value of last item in the list.
     */
    E pop();

    /**
     * Remove item from the front, return value.
     *
     * @return value of the first item in the list.
     */
    E popFront();

    /**
     * Gets the value at the front of the list.
     *
     * @return value of the first item in the list.
     */
    E getFirst();

    /**
     * Gets the value of the last item in the list.
     *
     * @return value of the last item in the list.
     */
    E getLast();

    /**
     * Removes the first item in the list with this value.
     *
     * @param item item to remove.
     */
    void remove(E item);

    /**
     * Removes the item at the given index.
     *
     * @param index index at which to remove the item at.
     */
    void removeAt(int index);

    /**
     * Looks for item and returns first index found containing the item, -1 if nothing is found.
     *
     * @param item item to look the index up for.
     * @return first found index for item or -1 if not found.
     */
    int findIndex(E item);

    /**
     * Reverses the list.
     */
    void reverse();
}