package algorithm.list;

public interface List<E> extends Collection<E> {


    E get(int index);

    boolean remove(int index);

    boolean remove();

    boolean add(int index, E element);

    int search(E element);
}
