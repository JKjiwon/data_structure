package algorithm.list;

public interface List<E> {

    int size();

    boolean add(E element);

    E get(int index);

    boolean remove(int index);

    boolean remove();

    boolean add(int index, E element);

    boolean contains(E element);

    void clear();

    int search(E element);
}
