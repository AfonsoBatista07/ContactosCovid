package dataStructures;

public class Main {
	public static void main(String[] args) { 
		/**
		HashTable<Integer, String> map = new ChainedHashTable<Integer, String>(3);
		map.insert(1, "Laranja");
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
		**/
		
		OrderedDictionary<Integer,String> tree = new AVLTree<Integer,String>();
		tree.insert(5, "banana");
		tree.insert(6, "Orange");
		tree.insert(3, "Apple");
		tree.insert(10, "ABACATE");
		Iterator<Entry<Integer,String>> it = tree.iterator();
		while(it.hasNext()) {
			Entry<Integer, String> entry = it.next();
			System.out.println(entry.getKey()+", "+ entry.getValue());
		}
		System.out.println("end");
		tree.remove(5);
		Iterator<Entry<Integer,String>> ite = tree.iterator();
		while(ite.hasNext()) {
			Entry<Integer, String> entry = ite.next();
			System.out.println(entry.getKey()+", "+ entry.getValue());
		}
		System.out.println("end");
		tree.insert(1, "banana");
		tree.remove(5);
		Iterator<Entry<Integer,String>> iter = tree.iterator();
		while(iter.hasNext()) {
			Entry<Integer, String> entry = iter.next();
			System.out.println(entry.getKey()+", "+ entry.getValue());
		}
		System.out.println("end");
		tree.remove(10);
		Iterator<Entry<Integer,String>> itera = tree.iterator();
		while(itera.hasNext()) {
			Entry<Integer, String> entry = itera.next();
			System.out.println(entry.getKey()+", "+ entry.getValue());
		}
		System.out.println("end");
		OrderedDictionary<Integer,String> tree2 = new AVLTree<Integer,String>();
		tree2.insert(8, "banana");
		tree2.insert(5, "ABACATE");
		tree2.insert(7, "Apple");
		tree2.insert(6, "Orange");
		tree2.insert(2, "A");
		tree2.insert(3, "B");
		tree2.insert(1, "C");
		Iterator<Entry<Integer,String>> iterat = tree2.iterator();
		while(iterat.hasNext()) {
			Entry<Integer, String> entry = iterat.next();
			System.out.println(entry.getKey()+", "+ entry.getValue());
		}
		System.out.println("end");
		tree2.remove(5);
		Iterator<Entry<Integer,String>> iterato = tree2.iterator();
		while(iterato.hasNext()) {
			Entry<Integer, String> entry = iterato.next();
			System.out.println(entry.getKey()+", "+ entry.getValue());
		}
	}
}
