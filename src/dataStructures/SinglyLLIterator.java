package dataStructures;

/**
 * Implementation of Iterator for SinglyLinkedList 
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 * 
 */
import dataStructures.SinglyLinkedList.SListNode;


public class SinglyLLIterator<E> implements Iterator<E> {
	/**
	 * Serial Version UID of the Class
	 */
	static final long serialVersionUID = 0L;
	
    /** 
     * Node with the first element in the iteration.
     */
    protected SListNode<E> firstNode;

    /**
     * Node with the next element in the iteration.
     */
    protected SListNode<E> nextToReturn;


    public SinglyLLIterator( SListNode<E> first )
    {
        firstNode = first;
        this.rewind();
    }  
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub

	}

}
