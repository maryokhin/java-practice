package dataStructures.list;

/**
 * Interface for implementing a resizable/dynamic/mutable array.
 *
 * @param <E> type of item that the list will contain.
 */
public interface ArrayList<E> {
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
     * Looks for item and removes index holding it (even if in multiple places).
     *
     * @param item item to remove.
     */
    void remove(E item);

    /**
     * Looks for item and returns first index found containing the item, -1 if nothing is found.
     *
     * @param item item to look the index up for.
     * @return first found index for item or -1 if not found.
     */
    int findIndex(E item);
}