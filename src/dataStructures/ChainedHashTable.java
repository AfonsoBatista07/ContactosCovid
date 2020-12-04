package dataStructures;  

/**
 * Chained Hash table implementation
 * @author AED  Team
 * @version 1.0
 * @param <K> Generic Key, must extend comparable
 * @param <V> Generic Value 
 */

public class ChainedHashTable<K extends Comparable<K>, V> 
    extends HashTable<K,V> 
{ 
	//The array of dictionaries.
    protected Dictionary<K,V>[] table;


    /**
     * Constructor of an empty chained hash table,
     * with the specified initial capacity.
     * Each position of the array is initialized to a new ordered list
     * maxSize is initialized to the capacity.
     * @param capacity defines the table capacity.
     */
    public ChainedHashTable( int capacity ) {
      
        table = newTable(capacity);
        maxSize = capacity;
        currentSize = 0;
    }                                      


    public ChainedHashTable() {
        this(DEFAULT_CAPACITY);
    }                                                                

    /**
     * Returns the hash value of the specified key.
     * @param key to be encoded
     * @return hash value of the specified key
     */
    protected int hash( K key ) {
        return Math.abs( key.hashCode() ) % table.length;
    }

    @Override
    public V find( K key ) {
    	return table[hash(key)].find(key);
    }

    @Override
    public V insert(K key, V value) {
        if ( this.isFull() )
            this.rehash();
        currentSize++;
        return table[hash(key)].insert(key, value);
    }

    @Override
    public V remove(K key) {
    	currentSize--;
    	return table[hash(key)].remove(key);
    }

    @Override
    public Iterator<Entry<K,V>> iterator() {
    	return new IteratorHashTable<K,V>(table);
    }
    
    public Iterator<V> values() {
    	return new IteratorValues<K,V>(table);
    }
    
    /**
     * Creates a new table with more space and makes a rehash of the elements.
     */
    private void rehash() {
		maxSize = 2*maxSize;
		table = newTable(maxSize);
		currentSize = 0;
		
		Iterator<Entry<K, V>> it = iterator();
		while(it.hasNext()) {
			Entry<K,V> entry = it.next();
			table[hash(entry.getKey())].insert(entry.getKey(), entry.getValue());
		}
    }
    
    /**
     * @param capacity - capacity for new table.
     * @return
     */
    @SuppressWarnings("unchecked")
    private Dictionary<K,V>[] newTable(int capacity) {
    	int arraySize = HashTable.nextPrime((int) 1.1 * capacity);
		Dictionary<K,V>[] newTable = new Dictionary[arraySize];
		
		for ( int i = 0; i < arraySize; i++ )
			newTable[i] = new CollisionList<K,V>();
		return newTable;
    }
}
