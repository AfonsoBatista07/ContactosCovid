package dataStructures;

import dataStructures.DoublyLinkedList.DListNode;

public class CollisionList<K extends Comparable<K>, V> implements Dictionary<K, V> {
	
	// Node at the head of the list.
	private DListNode<Entry<K, V>> head;

	// Node at the tail of the list.
	private DListNode<Entry<K, V>> tail;

	// Number of elements in the list.
	protected int currentSize;
	
	public CollisionList() {
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
	public V find(K key) {
		return findNode(key).getElement().getValue();
	}
	
	public DListNode<Entry<K, V>> findNode(K key) {
		DListNode<Entry<K, V>> newNode=head;
		Entry<K, V> entry;
		while(!newNode.equals(null)) {
			entry = newNode.getElement();
			if(entry.getKey().equals(key))
				return newNode;
			newNode = newNode.getNext();
		}
		return null;
	}

	@Override
	public V insert(K key, V value) {
		DListNode<Entry<K, V>> newNode =
				new DListNode<Entry<K,V>>(new EntryClass<K, V>(key, value));
		DListNode<Entry<K, V>> currentNode = head;
		while(currentNode != null) {
			
			int currentKeyCompare = currentNode.getElement().getKey().compareTo(key);
			
			if(currentKeyCompare > 0) {
				add(currentNode.getPrevious(), newNode);
				return null;
			} else if(currentKeyCompare == 0) {
				V oldValue = currentNode.getElement().getValue();
				currentNode.getElement().setValue(value);
				return oldValue;
			}
				
			currentNode=currentNode.getNext();
		}
		addLast(newNode);
		return null;
		
	}
	
	private void add( DListNode<Entry<K, V>> currentNode, DListNode<Entry<K, V>> newNode) {
		if(currentNode.equals(head) || currentNode==null)
			addFirst(newNode);
		else
			addMiddle(currentNode, newNode);
		currentSize++;
	}
	
	private void addMiddle(DListNode<Entry<K, V>> secondNode, DListNode<Entry<K, V>> newNode) {                         
		DListNode<Entry<K, V>> firstNode = secondNode.getPrevious();
		firstNode.setNext(newNode); secondNode.setPrevious(newNode);
	}
	
	private void addFirst(DListNode<Entry<K, V>> newNode) {
		head=newNode;
		tail=head;
	}
	
	private void addLast(DListNode<Entry<K, V>> newNode) {
		if(isEmpty()) { head=newNode; tail=head; }
		else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail=newNode;
		}
		currentSize++;
	}

	@Override
	public V remove(K key) {
		DListNode<Entry<K, V>> node = findNode(key);
		
		if(node==null) throw new NoKeyException();
		if(currentSize == 1) { head = null; tail = null; }
		else if(node.equals(head))
			removeFirst();
		else if(node.equals(tail))
			removeLast();
		else
			removeMiddle(node);
		currentSize--;
		return node.getElement().getValue();
	}
	
	private void removeFirst() {
		head = head.getNext();
		head.setPrevious(null);
	}
	
	private void removeLast() {
		tail = tail.getPrevious();
		tail.setNext(null);
	}
	
	private void removeMiddle(DListNode<Entry<K, V>> node) {
		DListNode<Entry<K, V>> firstNode = node.getPrevious();
    	DListNode<Entry<K, V>> secondNode = node.getNext();
    	firstNode.setNext(secondNode);
    	secondNode.setPrevious(firstNode);
    	node=null;
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new DoublyLLIterator<Entry<K, V>>(head, tail);
	}

}
