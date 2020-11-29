package dataStructures;

public class IteratorValues<K,V> implements Iterator<V> {
		
	/**
	* 
	*/
	private static final long serialVersionUID = -3757572178582017024L;
	private Iterator<Entry<K,V>> iterator;
		
	public IteratorValues(Dictionary<K,V>[] table) {
		iterator = new IteratorHashTable<K,V>(table);
	}
		
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	//Meter o getFirst aqui dentro
	public V next() throws NoSuchElementException {
		return iterator.next().getValue();
	}	

	@Override
	public void rewind() {
		iterator.rewind();
	}

}
