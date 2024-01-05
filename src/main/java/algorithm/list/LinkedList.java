package algorithm.list;

public class LinkedList<E> implements List<E>, Queue<E> {

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
        return add(size, element);
    }

    public boolean addFirst(E element) {
        return add(0, element);
    }

    public boolean addLast(E element) {
        return add(size, element);
    }

    @Override
    public boolean add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = head;
            size++;
            return true;
        }

        if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
            return true;
        }

        // 마지막
        if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
            return true;
        }

        // 가운데
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node<E> prevNode = current.prev;

        newNode.next = current;
        newNode.prev = current.prev;

        prevNode.next = newNode;
        current.prev = newNode;
        size++;

        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }

        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return true;
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node<E> prevNode = current.prev;
        Node<E> nextNode = current.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;

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
    public boolean remove() {
        return remove(size - 1);
    }


    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int search(E element) {
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            if (current.data.equals(element)) {
                return i;
            }
            current = current.next;
        }

        return -1;
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

    @Override
    public boolean offer(E e) {
        return addLast(e);
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object element) {

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
    public E poll() {
        E element = peek();
        remove(0);
        return element;
    }

    public static class Node<E> {
        private E data;
        private Node<E> next;

        private Node<E> prev;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }
}
