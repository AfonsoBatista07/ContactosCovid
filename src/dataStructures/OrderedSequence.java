package dataStructures;

public interface OrderedSequence<E extends Comparable<E>> {
    void insert(E element);
   
    boolean remove(E element);

    boolean contains(E element);

    E get(E element);

    Iterator<E> iterator();
}
