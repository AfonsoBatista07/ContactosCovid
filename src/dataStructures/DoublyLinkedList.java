package dataStructures;

/**
 * Doubly linked list Implementation 
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 * 
 */
public class DoublyLinkedList<E> implements List<E>  {

	/**
	 * Serial Version UID of the Class
	 */
	static final long serialVersionUID = 0L;

	static class DListNode<E>{
		// Element stored in the node.
		protected E element;
		// (Pointer to) the next node.
		protected DListNode<E> next;
		// (Pointer to) the previous node.
		protected DListNode<E> previous;

		public DListNode( E elem, DListNode<E> thePrev, DListNode<E> theNext ){
			element = elem;
			previous = thePrev;
			next = theNext;
		}
		
		public DListNode( E theElement ){
			this(theElement, null, null);
		}

		public E getElement( ){
			return element;
		}

		public DListNode<E> getNext( ){
			return next;
		}

		public DListNode<E> getPrevious( ){
			return previous;
		}

		public void setElement( E newElement ){
			element = newElement;
		}

		public void setNext( DListNode<E> newNext ){
			next = newNext;
		}

		public void setPrevious( DListNode<E> newPrevious ){
			previous = newPrevious;
		}

	}


	// Node at the head of the list.
	private DListNode<E> head;

	// Node at the tail of the list.
	private DListNode<E> tail;

	// Number of elements in the list.
	protected int currentSize;

	public DoublyLinkedList( ){
		head = null;
		tail = null;
		currentSize = 0;
	}

	@Override
	public boolean isEmpty() {
		return currentSize==0;
	}

	@Override
	public int size() {
		return currentSize;
	}


	@Override
	public int find(E element) {
		DListNode<E> newNode=head;
		for(int pos=0; pos<currentSize;pos++) {
			if(newNode.getElement().equals(element))
				return pos;
			newNode=newNode.getNext();
		}
		return -1;
	}


	@Override
	public E getFirst() throws NoElementException {
		if(isEmpty()) throw new NoElementException();
		return head.getElement();
	}

	@Override
	public E getLast() throws NoElementException {
		if(isEmpty()) throw new NoElementException();
		return tail.getElement();
	}

	@Override
	public E get(int position) throws InvalidPositionException {
		if (position<0 || position>=currentSize) 
			throw new InvalidPositionException();
		return getNode(position).getElement();
	}
	
	/**
	 * @param position - Position of node to be returned.
	 * @return a node at a <position>.
	 */
	private DListNode<E> getNode(int position){
		DListNode<E> newNode;
		
		if(position<=currentSize/2) {             			    //Se estiver mais perto da head
			newNode=head;
			for(int i=1;i<=position;i++)
				newNode=newNode.getNext();
		} else {                                                 //Se estiver mais perto da tail
			newNode=tail;
			for(int i=currentSize-1;i>=position;i--)
				newNode=newNode.getNext();
		}
		return newNode;
	}
	

	@Override
	public void addFirst(E element) {
		DListNode<E> newNode = new DListNode<E>(element,null,head);
		if(!isEmpty()) { 
			head.setPrevious(newNode);
			head=newNode;
		} else {
			head=newNode;
			tail=head;
		}
		
		currentSize++;
	}
	
	/**
	 * @param position - Position of element to be added.
	 * @param element - Element to be added at a position.
	 */
	private void addMiddle(int position, E element) {
		DListNode<E> secondNode=getNode(position);
		DListNode<E> firstNode = getNode(position-1);
		DListNode<E> newNode = new DListNode<E>(element,firstNode,secondNode);
		firstNode.setNext(newNode); secondNode.setPrevious(newNode);
		currentSize++;
		
	}

	@Override
	public void addLast(E element) {
		DListNode<E> newNode = new DListNode<E>(element);
		if(isEmpty()) { head=newNode; tail=head; }
		else {
			tail.setNext(newNode);
			tail=tail.getNext();
		}
		
		currentSize++;
	}

	
	@Override
	public void add(int position, E element) throws InvalidPositionException {
		if (position<0 || position > currentSize) 
			throw new InvalidPositionException();
		if (position==0) 
			addFirst(element);
		else if (position==currentSize) 
			addLast(element);
		else {
			addMiddle(position,element);
		}

	}

    /**
     * Removes the first node in the list.
     * Pre-condition: the list is not empty.
     */
    private void removeFirstNode() {
    	DListNode<E> secondNode=head.getNext();
    	secondNode.setPrevious(null);
    	head=secondNode;
    	currentSize--;
    }


    @Override
    public E removeFirst() throws NoElementException {
        if (isEmpty()) throw new NoElementException();

        E element = head.getElement();
        this.removeFirstNode();
        return element;
    }
	
    /**
     * Removes the last node in the list.
     * Pre-condition: the list is not empty.
     */
    private void removeLastNode() {
    	DListNode<E> secondLastNode=tail.getPrevious();
    	secondLastNode.setNext(null);
    	tail=secondLastNode;
    	currentSize--;
    }


    @Override 
    public E removeLast() throws NoElementException {
        if (isEmpty()) throw new NoElementException();

        E element = tail.getElement();
        this.removeLastNode();
        return element;
    }
    
    /**
     * Removes the specified node from the list.
     * Pre-condition: the node is neither the head nor the tail of the list.
     * @param node - middle node to be removed
     */
    private void removeMiddleNode(DListNode<E> node) {
    	DListNode<E> firstNode = node.getPrevious();
    	DListNode<E> secondNode = node.getNext();
    	firstNode.setNext(secondNode);
    	secondNode.setPrevious(firstNode);
    	node=null;
    }
    
	/**
	 * @param position - Position of element to be returned.
	 * @return - the element at <position>.
	 */
	private E removeMiddle(int position) {
		DListNode<E> nodeToRemove = this.getNode(position);
		this.removeMiddleNode(nodeToRemove);
		return nodeToRemove.getElement();
	}

	@Override
	public E remove(int position) throws InvalidPositionException {
		if(position<0 || position>=currentSize)
			throw new InvalidPositionException();
		if (position==0)
			return removeFirst();
		if (position==currentSize-1)
			return removeLast();
		return removeMiddle(position);
	}

	@Override
	public boolean remove(E element) {
		DListNode<E> node = this.findNode(element);
		if ( node == null )
			return false;
		else {
			if ( node == head )
				this.removeFirstNode();
			else if ( node == tail )
				this.removeLastNode();
			else
				this.removeMiddleNode(node);
			return true;
		}
	}
	
	/**
	 * @param element - Element to be found.
	 * @return node that has <element>.
	 */
	private DListNode<E> findNode(E element) {
		int pos=0;
		boolean found = false;
		while(pos<currentSize && !found) {
			if(getNode(pos).equals(element)) {
				found = true;
				return getNode(pos);
			} 
			pos++;
		}
		return null;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new DoublyLLIterator<E>(head,tail);
	}

    /**
     * Removes all of the elements from the specified list and
     * inserts them at the end of the list (in proper sequence).
     * @param list - list to be appended to the end of this
     */
    public void append( DoublyLinkedList<E> list ) {
        tail.setNext(list.head);
        list.head.setPrevious(tail);
        tail=list.tail;
        list.head=null; list.tail=null;
        currentSize+=list.currentSize;
    }



}
