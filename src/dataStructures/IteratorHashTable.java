package dataStructures;

/**
 * Iterator hash table implementation.
 * @author Afonso Batista 57796  
 * @author Joao Jorge 57994  
 * 
 * @param <K> Generic type Key.
 * @param <V> Generic type Value. 
 */
public class IteratorHashTable<K,V> implements Iterator<Entry<K,V>> {
	
	private static final long serialVersionUID = -3757572178582017026L;
	
	private Entry<K, V> next;
	private int pos;
	private Iterator<Entry<K,V>> iterator;
	private Dictionary<K,V>[] table;
	
	public IteratorHashTable(Dictionary<K,V>[] table) {
		this.table = table;
		pos = 0;
		iterator = null;
		updateNext();
	}
	
	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public Entry<K, V> next() throws NoSuchElementException {
		if(!hasNext()) throw new NoSuchElementException();
		Entry<K,V> returnNext = next;
			
		if( iterator.hasNext()) {
			next = iterator.next();
			return returnNext;
		}
		updateNext();
		return returnNext;
	}
	
	/**
	 * Move on to the next element in the table.
	 */
	private void updateNext() {
		Iterator<Entry<K,V>> it;
		while(pos<table.length-1) {
			pos++;
			it = table[pos].iterator();
			if(it.hasNext()) {    												
				next = it.next();
				iterator = it;
				return;
			}
		}
		next = null;
	}

	@Override
	public void rewind() {
		pos = 0;
		iterator = null;
		updateNext();
		
	}

	
}
