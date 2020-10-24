package dataStructures;

public class OrderedSequenceClass<E extends Comparable<E>>

implements OrderedSequence<E> {

    protected List<E> list; 
	
    public OrderedSequenceClass() {
    	list = new DoublyLinkedList<E>();
    }
	@Override
	public void insert(E element) {
		Iterator<E> it = iterator();
		boolean inserted = false;
		int pos = 0;
		while (it.hasNext() && !inserted) {
			if(it.next().compareTo(element) >= 0) {
				list.add(pos, element);
				inserted = true;
			}
			pos++;
		}
		if(!inserted) list.addLast(element);
		
	}

	@Override
	public boolean remove(E element) {
		return list.remove(element);
	}

	@Override
	public boolean contains(E element) {
		return get(element) != null;
	}

	@Override
	// Das um elemento que não existe e devolve um que existe mas que tem as mesmas carateristicas
	public E get(E element) {
		Iterator<E> it = iterator();
		while(it.hasNext()) {
			E object = it.next();
			if (object.compareTo(element) == 0)
				return object;
		}
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

}
