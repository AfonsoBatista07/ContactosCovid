package dataStructures;

/**
 * Singly linked list Implementation 
 * @author AED  Team
 * @version 1.0
 * @param <E> Generic Element
 * 
 */
public class SinglyLinkedList<E> implements List<E> {

	/**
	 * Serial Version UID of the Class
	 */
	static final long serialVersionUID = 0L;

	static class SListNode<E>{
		// Element stored in the node.
		protected E element;
		// (Pointer to) the next node.
		protected SListNode<E> next;

		public SListNode( E elem, SListNode<E> theNext ){
			element = elem;
			next = theNext;
		}

		public SListNode( E theElement ){
			this(theElement, null);
		}

		public E getElement( ){
			return element;
		}

		public SListNode<E> getNext( ){
			return next;
		}

		public void setElement( E newElement ){
			element = newElement;
		}

		public void setNext( SListNode<E> newNext ){
			next = newNext;
		}

	}

	// Node at the head of the list.
	private SListNode<E> head;

	// Node at the tail of the list.
	private SListNode<E> tail;

	// Number of elements in the list.
	private int currentSize;

	public SinglyLinkedList() {
		head = null;
		tail = null;
		currentSize=0;
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
	public Iterator<E> iterator() throws NoElementException {
		return new SinglyLLIterator<E>(head);
	}

	@Override
	public int find(E element) {
		int i=0;
		while(i<currentSize) {
			if(get(i).equals(element)) {
				return i;
			} 
			i++;
		}
		return -1;
	}
	
	private SListNode<E> getNode(int position){
		SListNode<E> node=head;
		for(int i=1;i<=position;i++)
			node=node.getNext();
		return node;
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
		if(position<0 && position>=size()) throw new InvalidPositionException();
		
		return getNode(position).getElement();
	}

	@Override
	public void addFirst(E element) {
		SListNode<E> newNode = new SListNode<E>(element);
		if(!isEmpty()) { 
			newNode.setNext(head);
			head=newNode;
		} else { head=newNode; tail=head;  }
		currentSize++;
		
	}
	
	/**
	 * Adds element to te given position ( position cannot be 0 or currentSize)
	 * @param position - position
	 * @param element - Element
	 */
	private void addMiddle(int position, E element) {
		SListNode<E> newNode = new SListNode<E>(element);
		SListNode<E> firstNode = getNode(position-1);
		SListNode<E> secondNode = firstNode.getNext();
		newNode.setNext(secondNode);
		firstNode.setNext(newNode);
		currentSize++;
	}

	@Override
	public void addLast(E element) {
		SListNode<E> newNode = new SListNode<E>(element);
		if(isEmpty()) { head=newNode; tail=head; }
		else {
			tail.setNext(newNode);
			tail=tail.getNext();
		}
		
		currentSize++;
		
	}

	@Override
	public void add(int position, E element) throws InvalidPositionException {
		if(position<0 && position>=currentSize) throw new InvalidPositionException();
		if(position==0) addFirst(element);
		else if(position==currentSize) addLast(element);
		else addMiddle(position, element);
	}

	@Override
	public E removeFirst() throws NoElementException {
		if(isEmpty()) throw new NoElementException();
		E element = head.getElement();
		if(currentSize == 1) {
			head = null;
			tail = null;
		}
		else {
			SListNode<E> nextNode = head.getNext();
			head=nextNode;
		}
		currentSize--;
		return element;
	}
	
	/**
	 * Removes element to te given position ( position cannot be 0 or currentSize)
	 * @param position - position
	 * @return Element removed
	 */
	private E removeMiddle(int position) {
		SListNode<E> firstNode = getNode(position -1);
		SListNode<E> secondNode = firstNode.getNext();
		SListNode<E> thirdNode = secondNode.getNext();
		
		E element = secondNode.getElement();
		firstNode.setNext(thirdNode);
		currentSize--;
		return element;
	}

	@Override
	public E removeLast() throws NoElementException {
		if(isEmpty()) throw new NoElementException();
		E element = tail.getElement();
		if(currentSize == 1) {
			head = null;
			tail = null;
		} else {
			SListNode<E> secondLast = getNode(currentSize-2);
			secondLast.setNext(null);
			tail = secondLast;
		}
		currentSize--;
		return element;
	}

	@Override
	public E remove(int position) throws InvalidPositionException {
		if(position<0 && position>=currentSize) throw new InvalidPositionException();
		if(position==0) return removeFirst();
		else if(position==currentSize) return removeLast();
		else return removeMiddle(position);
	}
	

	@Override
	public boolean remove(E element) {
		try {
			int position=find(element);
			remove(position);
			return true;
		} catch(InvalidPositionException e) {
			return false;
		}
	}
}
