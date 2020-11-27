package dataStructures;

import dataStructures.BinarySearchTree.BSTNode;

public class BSTKeyOrderIterator<K,V> implements Iterator<Entry<K,V>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4565987179362609417L;
	private BSTNode<K,V> next;
	private BSTNode<K,V> root;
	private Stack<BSTNode<K,V>> stack;
	
	public BSTKeyOrderIterator(BSTNode<K,V> root) {
		this.root = root;
		stack = new StackInList<BSTNode<K,V>>();
		next = leftMost(root);
	}
	
	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public Entry<K,V> next() throws NoSuchElementException {
		if(!hasNext()) throw new NoSuchElementException();
		BSTNode<K,V> nextToReturn = next;
		if(next.getRight() != null) {
			next = leftMost(next.getRight());
		}else {
			if(stack.isEmpty())
				next = null;
			else
				next = stack.pop();
		}
		return nextToReturn.getEntry();
	}
	
	private BSTNode<K,V> leftMost(BSTNode<K,V> node) {
		while(node != null) {
			stack.push(node);
			node = node.getLeft();
		}
		return stack.pop();
	}

	@Override
	public void rewind() {
		while(!stack.isEmpty())
			stack.pop();
		next = leftMost(root);
	}

}
