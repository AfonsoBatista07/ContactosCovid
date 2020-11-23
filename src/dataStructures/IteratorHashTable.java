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
		Entry<K,V> returnNext = next;
		if( iterator.hasNext()) {
			next = iterator.next();
			return returnNext;
		}
		while(pos<table.length-1) {
			Iterator<Entry<K,V>> it = table[pos].iterator();
			if(it.hasNext()) {
				next = it.next();
				iterator = it;
				return returnNext;
			}
			pos++;
		}
		next = null;
		return returnNext;
	}
	
	private Entry<K, V> getFirst() {
		boolean found = false;
		int i = pos;
		Entry<K,V> returnNext = null;
		while(i<table.length && !found) {
			Iterator<Entry<K,V>> it = table[i].iterator();
			if(it.hasNext()) {
				returnNext = it.next();
				iterator = it;
				found = true;
			}
			i++;
		}
		if(found) return returnNext;
		return null;
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub
		
	}

	
}
