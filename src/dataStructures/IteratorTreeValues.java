package dataStructures;

import dataStructures.BinarySearchTree.BSTNode;

/**  
 * Binary Search Tree Value Key Order Iterator implementation
 * @author Afonso Batista 57796  
 * @author Joao Jorge 57994  
 */  

public class IteratorTreeValues<K,V> implements Iterator<V> {

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

