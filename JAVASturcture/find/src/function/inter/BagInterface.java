package function.inter;

/**
 * @description:An interface that describes the operation of a bag objects.
 * @author: Luck_chen
 * @date: 2023/4/14 11:10
 * @Version 1.0.0.0
 */
public interface BagInterface<T> {
    /**
     * Gets the current number of entries currently in the bag
     * @return the integer number of entries currently in the bag.
     */
    public int getCurrentSize();

    /**
     * Sees whether this bag is empty
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Adds a new entry to this bag
     * @param newEntry The object to be added as a new entry
     * @return
     */
    public boolean add(T newEntry);

    public boolean add(BagInterface<T> bag, T[] contentBag);

    /**
     * Removes one unspecified entry from this bag,if possible
     * @return Either the removed entry,if the removal was successful,or null
     */
    public T remove();

    /**
     * Remove one occurrence of a given entry appears in this bag
     * @param anEntry The entry to be counted
     * @return The number of times anEntry appears in the bag
     */
    public boolean remove(T anEntry);

    /**
     * Remove all entries that are in this bag
     */
    public void clear();

    /**
     * Counts the number of times a  given entry
     * @param anEntry The entry to be counted
     * @return The number of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry);


    /**
     * Tests whether this bag contains a given entry
     * @param anEntry The entry to locate
     * @return True if the bag contains anEntry,or false if not
     */
    public boolean contains(T anEntry);

    /**Retrieves all entries that are in this bag
     * @return  A newly allocated array of all the entries in the bag
     *          Note: If the bag is empty,the returned array is empty
     */
    public T[] toArray();

    /**
     * loop
     */
    public void loop();

} //end BagInterface