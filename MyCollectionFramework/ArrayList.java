package MyCollectionFramework;

import java.util.NoSuchElementException;
/**
 *<p>A List that can be traversed the same as an array, with the added benefit of being able
 *  to add or remove any element from any index in the array</p>
 * @Author Nicolas Alvarez
 * @Version 1.0
 * */
public class ArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    transient Object[] elementData;

    private int size = 0;

    /**
     * <p>Constructs ArrayList of given capacity,
     *  if capacity is greater than or equal to 0 else throws IllegalArgumentException</p>
     * @param initialCapacity desired capacity of ArrayList
     **/
    public ArrayList(int initialCapacity) {

        if (initialCapacity > 0) {

            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {

            this.elementData = new Object[]{};
        } else {

            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
    }

    /**
     *<p>Constructs empty ArrayList of default capacity(10)</p>
     **/
    public ArrayList(){

        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * <p>Appends list with given element resizing afterwards</p>
     * @param element desired elements to add to list
     **/
    public void add(E element){

        elementData[size] = element;
        size++;
    }

    /**
     * <p>Adds an element at a designated index, resizes and shifts ArrayList accordingly</p>
     * @param index index for desired element to be added
     * @param element the desired element to be placed at given index
     **/
    public void add(int index, E element){

        if(index <= size) {
            for (int iterator = size - 1; iterator >= index; iterator--) {

                elementData[iterator + 1] = elementData[iterator];
            }
            size++;
            elementData[index] = element;
        } else{

            throw new IndexOutOfBoundsException("Index " + index + " exceeds size of ArrayList(size = " + size + ")" );
        }
    }

    /**
     * <p>adds given element to front of list resizing</p>
     * @param element the desired element to add to front
     **/
    public void addFirst(E element){

        add(0, element);
    }

    /**
     * <p>adds given element to end of list resizing</p>
     * @param element the desired element to add to end
     **/
    public void addLast(E element){

        add(size, element);
    }

    /**
     * <p>gets the size of ArrayList</p>
     * @Returns: The size of the ArrayList
     **/
    public int size(){

        return size;
    }

    /**
     *<p>checks if the ArrayList is empty</p>
     * @Returns: 1 if size equals 0, else it returns 1
     **/
    public boolean isEmpty(){

        return size == 0;
    }

    /**
     * <p>Removes element at given index and resizes and shifts ArrayList if,
     * the index is within bounds of the ArrayList else throws NoSuchElementException</p>
     * @param index the index of desired element to remove
     * */
    public void remove(int index) {

        if(0 <= index && index < size && size > 0){

            for (int iterator = index; iterator < size; iterator++) {

                elementData[iterator] = elementData[iterator + 1];
            }
        size--;
        }
        else{

            throw new NoSuchElementException("There is no element at index " + index);
        }
    }

    /**
     * <p>Removes the first element in ArrayList if ArrayList size is greater than zero,
     * else throws NoSuchElementException<p/>
     * */
    public void removeFirst(){
        if(size == 0){

            throw new NoSuchElementException("There are no elements to remove");
        }
        else{

            remove(0);
        }
    }

    /**
     * <p>Removes the last element in ArrayList if ArrayList size is greater than zero,
     * else throws NoSuchElementException<p/>
     * */
    public void removeLast(){
        if(size == 0){

            throw new NoSuchElementException("There are no elements to remove");
        }
        else{

            remove(size - 1);
        }
    }

    /**
     * <p>gets the element at given index as you would with an array,
     * if element is out of bounds throws IndexOutOfBounds Exception</p>
     * @param index the index of desired element
     * @Returns: The element at the given index
     **/
    @SuppressWarnings("unchecked")
    public E get(int index){

        return (E)elementData[index];
    }

    /**
     * <p>Sets the element at the given index to the given element,
     * if element is out of bounds throws IndexOutOfBounds Exception</p>
     * @param index the index of desired element to set
     * @param element the new element the old one is being overwritten with
     * */
    public void set(int index, E element){

        if(index < size) {

            elementData[index] = element;
        }
        else{

            throw new IndexOutOfBoundsException("The given index is out of bounds of the ArrayList");
        }
    }

    /**
     * <p>Method to return ArrayList as an Array</p>
     * @Returns: returns Object array comprised of the ArrayList's elements
     * */
    public Object[] toArray(){

            Object[] returnArray = new Object[size];
            for (int iterator = 0; iterator < size; iterator++) {

                returnArray[iterator] = elementData[iterator];
            }
            return returnArray;
    }

    /**
     * <p>Method to return ArrayList as String</p>
     * @Returns: String interpretation of ArrayList
     * */
    @Override
    public String toString() {

        String returnString = "[" + get(0);
        if(size > 1) {

            for (int iterator = 1; iterator < size; iterator++) {

                returnString = returnString.concat(", " + get(iterator));
            }
        }
        return returnString.concat("]");
    }
}

