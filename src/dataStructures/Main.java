package dataStructures;

public class Main {
	public static void main(String[] args) { 
		HashTable<Integer, String> map = new ChainedHashTable<Integer, String>(3);
		map.insert(1, "Banana");
		map.insert(19, "abacate");
		map.insert(21, "yakusa");
		System.out.println(map.find(2));
		System.out.println(map.find(1));
		Iterator<Entry<Integer,String>> it = map.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getValue());
		}
		map.rehash();
		Iterator<Entry<Integer,String>> ite = map.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next().getValue());
		}
	}
}
