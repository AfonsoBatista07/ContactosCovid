package dataStructures;

/**  
 * Entry Class implementation
 * @author Afonso Batista 57796  
 * @author Joao Jorge 57994  
 */  

public class EntryClass<K, V> implements Entry<K, V> {

	private K key;
	private V value;
	
	public EntryClass(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}

}
