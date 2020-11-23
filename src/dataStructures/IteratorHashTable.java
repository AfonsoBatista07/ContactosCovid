package dataStructures;

public class IteratorHashTable<K,V> implements Iterator<Entry<K,V>> {
	
	private Entry<K, V> next;
	private int pos;
	private Iterator<Entry<K,V>> iterator;
	private Dictionary<K,V>[] table;
	
	public IteratorHashTable(Dictionary<K,V>[] table) {
		this.table = table;
		pos = 0;
		iterator = null;
		next = getFirst();
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
		while(pos<table.length-1) {
			pos++;
			Iterator<Entry<K,V>> it = table[pos].iterator();
			if(it.hasNext()) {    													// BETTER CODING !!!!!!!!!!!!!!!!!!!!!!1
				next= it.next();
				iterator = it;
				return returnNext;
			}
		}
		next = null;
		return returnNext;
	}
	
	private Entry<K, V> getFirst() {
		Entry<K,V> returnNext = null;
		while(pos<table.length-1) {
			pos++;
			Iterator<Entry<K,V>> it = table[pos].iterator();
			if(it.hasNext()) {
				returnNext = it.next();
				iterator = it;
				return returnNext;
			}
		}
		next = null;
		return returnNext;
	}

	@Override
	public void rewind() {
		pos = 0;
		iterator = null;
		next = getFirst();
		
	}

	
}
