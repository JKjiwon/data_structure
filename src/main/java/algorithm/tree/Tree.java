package algorithm.tree;

import algorithm.list.LinkedList;
import algorithm.list.Queue;

public class Tree<E> {
    public Node<E> root;

    public Tree(Node<E> root) {
        this.root = root;
    }

    public void bfs() {
        Queue<Node<E>> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node<E> cur = q.poll();
            System.out.print(cur.data + " ");

            if (cur.left != null) {
                q.offer(cur.left);
            }

            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        System.out.println();
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static class Node<E> {
        public E data;
        public Node<E> left;

        public Node<E> right;

        public Node(E data, Node<E> left, Node<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
