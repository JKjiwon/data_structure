package algorithm.list;

public interface Collection<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean add(E e);


    void clear();

}
