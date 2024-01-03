package algorithm.list;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;

    private int size;

    public LinkedList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        Node<E> node = new Node<>(element);
        size++;
        if (head == null) {
            head = node;
            tail = head;
            return true;
        }

        tail.next = node;
        tail = node;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        Node<E> node = new Node<>(element);
        size++;

        if (head == null) {
            head = node;
            tail = head;
            return true;
        }

        if (index == 0) {
            node.next = head;
            head = node;
            return true;
        }

        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;


        if (node.next == null) {
            tail = node;
        }

        return true;
    }

    @Override
    public E get(int index) {
        if (index < 0 && index >= size) {
            return null;
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 && index >= size) {
            return false;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return true;
        }

        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;

        return true;
    }

    @Override
    public boolean remove() {
        return remove(size - 1);
    }

    @Override
    public boolean contains(E element) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;

        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(current.data);
            if (i != size - 1) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");

        return sb.toString();
    }

    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
}
