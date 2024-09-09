package MyCollectionFramework;

import java.util.Iterator;

/**
 *<p>Interface for all collections of elements of type E</p>
 * @param <E> type of element in collection
 * @author Nicolas Alvarez
 * @version 1.0
 **/
public interface Collection<E> extends Iterable<E> {

    /**
     * <p>Adds given element of type E</p>
     * @param o desired element to add
     **/
    boolean add(E o);

    /**
     * <p>Adds all of the given Collection to the this Collection</p>
     * @param collection Given Collection to add to Collection elements
     **/
    boolean addAll(Collection<? extends E> collection);

    /**
     * <p>Clears the elements within a Collection</p>
     **/
    void clear();

    /**
     * <p>Checks the boolean value of the Collection containing a given Object</p>
     * @param object desired object to check
     * @return true if object is contained within Collection
     **/
    boolean contains(Object object);

    /**
     * <p>Checks the boolean value of the Collection containing a given collection</p>
     * @param collection desired object to check
     * @return true if collection is contained within Collection
     **/
    boolean containsAll(Collection<?> collection);

    /**
     * <p>Checks the boolean value of the Collection equaling a given Object</p>
     * @param object desired object to check equivalency
     * @return true if object is equal to Collection
     **/
    boolean equals(Object object);

    /**
     * <p>Gets hash code of Collection</p>
     * @return hash code of Collection
     **/
    int hashCode();

    /**
     * <p>Checks if Collection is empty</p>
     * @return true if Collection is empty
     **/
    boolean isEmpty();

    /**
     * <p>Used to iterate through Collection</p>
     **/
    Iterator<E> iterator();

    /**
     * <p>Removes given Object</p>
     * @param object desired object to remove
     **/
    boolean remove(Object object);

    /**
     * <p>removes all elements within this Collection from given collection</p>
     * @param collection desired collection to remove from
     **/
    boolean removeAll(Collection<?> collection);

    /**
     * <p>Used to only retain a sub-collection of elements withing this Collection</p>
     * @param collection desired collection to retain
     **/
    boolean retainAll(Collection<?> collection);

    /**
     * <p>Gets size of Collection</p>
     * @return size of Collection
     **/
    int size();

    /**
     * <p>Converts Collection to Array</p>
     * @return Array converted from Collection
     **/
    Object[] toArray();

    /**
     * <p>Converts Collection to Array of given Array Type with set </p>
     * @param <T> given type of returned array
     * @param a given array to base returned array off of
     * @return Array of specified type converted from Collection
     **/
    <T> T[] toArray(T[] a);
}
