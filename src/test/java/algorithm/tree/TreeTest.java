package algorithm.tree;

import org.junit.jupiter.api.Test;

class TreeTest {
    Tree.Node<String> h = new Tree.Node<>("H", null, null);
    Tree.Node<String> i = new Tree.Node<>("I", null, null);
    Tree.Node<String> j = new Tree.Node<>("J", null, null);
    Tree.Node<String> k = new Tree.Node<>("K", null, null);
    Tree.Node<String> l = new Tree.Node<>("L", null, null);
    Tree.Node<String> g = new Tree.Node<>("G", null, null);

    Tree.Node<String> d = new Tree.Node<>("D", h, null);
    Tree.Node<String> e = new Tree.Node<>("E", i, j);
    Tree.Node<String> f = new Tree.Node<>("F", k, l);
    Tree.Node<String> c = new Tree.Node<>("C", f, g);
    Tree.Node<String> b = new Tree.Node<>("B", d, e);
    Tree.Node<String> a = new Tree.Node<>("A", b, c);

    Tree<String> tree = new Tree<>(a);
    @Test
    void preOrder() {
        tree.preOrder();
    }

    @Test
    void inOrder() {
        tree.inOrder();
    }

    @Test
    void postOrder() {
        tree.postOrder();
    }

    @Test
    void bfs() {
        tree.bfs();
    }
}