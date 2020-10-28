package dataStructures;

public interface OrderedSequence<E extends Comparable<E>> {
    /**
     * insert an <element> on sequence.
     * @param element - element to be inserted on sequence.
     */
    void insert(E element);
   
    /**
     * @param element - element to be removed from sequence.
     * @return true if has removed the <element> and false if not.
     */
    boolean remove(E element);

    /**
     * @param element - element to be verified if it exists on sequence. 
     * @return true if the sequence contains the <element> and false if not.
     */
    boolean contains(E element);

    /**
     * @param element - element to be returned if it exists.
     * @return the element needed, null if the element doesn't exist.
     */
    E get(E element);

    /**
     * @return a iterator with all the elements on sequence.
     */
    Iterator<E> iterator();
    
}