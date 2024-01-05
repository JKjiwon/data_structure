package algorithm.list;

public class Stack<E> extends ArrayList<E> {

    public E push(E item) {
        add(item);
        return item;
    }

    public E pop() {
        E item = get(size() - 1);
        remove(size() - 1);
        return item;
    }

    public E peek() {
        return get(size() - 1);
    }
}
