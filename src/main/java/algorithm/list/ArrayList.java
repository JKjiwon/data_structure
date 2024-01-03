package algorithm.list;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_ELEMENT_CAPACITY = 100;

    private E[] array;

    private int size;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.array = (E[]) new Object[DEFAULT_ELEMENT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        if (size == array.length) {
            return false;
        }

        array[size] = element;
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 && index >= size) {
            return null;
        }

        return array[index];
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 && index > size - 1) {
            return false;
        }

        for (int i = index; i < size - 1; i++) {
            array[index] = array[index + 1];
        }
        size--;
        return true;
    }

    @Override
    public boolean remove() {
        if (size == 0) {
            return false;
        }

        size--;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if (size == array.length) {
            return false;
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
        size++;
        return true;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
