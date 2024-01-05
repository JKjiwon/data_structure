package algorithm.list;

public interface Queue<E> extends Collection<E> {
    boolean offer(E e);

    E peek();

    E poll();
}
