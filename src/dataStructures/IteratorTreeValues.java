package dataStructures;

import dataStructures.BinarySearchTree.BSTNode;

public class IteratorTreeValues<K,V> implements Iterator<V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4565987179362609417L;
	private Iterator<Entry<K,V>> iterator;
	
	public IteratorTreeValues(BSTNode<K,V> root) {
		iterator = new BSTKeyOrderIterator<K,V>(root);
	}
	
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public V next() throws NoSuchElementException {
		return iterator.next().getValue();
	}

	@Override
	public void rewind() {
		iterator.rewind();
	}

}

