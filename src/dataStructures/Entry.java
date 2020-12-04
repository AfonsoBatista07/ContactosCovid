package dataStructures;

/**
 * Entry Interface
 * @author Afonso Batista 57796  
 * @author Joao Jorge 57994  
 * @param <K> Generic Key
 * @param <V> Generic Value 
 */

public interface Entry<K,V> {
	
	//Returns the key in the entry
	K getKey();
	
	//Returns the value in the entry
	V getValue();
	
	/**
	 * Changes the value of the entry to the given Value
	 * @param value - Value
	 */
	void setValue(V value);
}
