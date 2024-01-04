package algorithm.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinkedListTest {
    LinkedList<Integer> list = new LinkedList<>();

    @BeforeEach
    void init() {
        list.clear();
    }

    @Test
    void add() {
        // given & when
        list.add(1);
        list.add(2);

        // then
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains(1)).isTrue();
        assertThat(list.contains(2)).isTrue();
        assertThat(list.toString()).isEqualTo("[1, 2]");
    }

    @Test
    void add_minus_index() {
        assertThatThrownBy(() -> list.add(-1, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void add_over_index() {
        list.add(1);
        list.add(2);
        assertThatThrownBy(() -> list.add(3, 3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void add_at() {
        // given
        list.add(1);
        list.add(2);

        // when
        list.add(1, 3); // 1, 3, 2
        list.add(1, 4); // 1, 4, 3, 2

        // then
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.contains(1)).isTrue();
        assertThat(list.contains(2)).isTrue();
        assertThat(list.contains(3)).isTrue();
        assertThat(list.contains(4)).isTrue();
        assertThat(list.toString()).isEqualTo("[1, 4, 3, 2]");
    }

    @Test
    void add_at2() {
        // given
        list.add(1);
        list.add(2);

        // when
        list.add(2, 3);
        list.add(4);

        // then
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.contains(1)).isTrue();
        assertThat(list.contains(2)).isTrue();
        assertThat(list.contains(3)).isTrue();
        assertThat(list.contains(4)).isTrue();
        assertThat(list.toString()).isEqualTo("[1, 2, 3, 4]");
    }

    @Test
    void get() {
        // given
        list.add(1);
        list.add(2);

        // when & then
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
    }

    @Test
    void remove() {
        //given
        list.add(1);
        list.add(2);
        list.add(3);

        // when
        list.remove();

        // then
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains(3)).isFalse();
        assertThat(list.toString()).isEqualTo("[1, 2]");
    }

    @Test
    void remove_minus_index() {
        assertThatThrownBy(() -> list.remove(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void remove_over_index() {
        list.add(1);
        list.add(2);
        assertThatThrownBy(() -> list.remove(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void remove_at() {
        //given
        list.add(1);
        list.add(2);
        list.add(3);

        // when
        list.remove(1);

        // then
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains(2)).isFalse();
        assertThat(list.toString()).isEqualTo("[1, 3]");
    }

    @Test
    void search() {
        // given
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // when && then
        assertThat(list.search(3)).isEqualTo(2);
        assertThat(list.search(5)).isEqualTo(-1);
    }

    @Test
    void remove_and_add1() {
        list.add(1);
        list.add(2);
        list.remove();
        list.add(3);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains(2)).isFalse();
        assertThat(list.toString()).isEqualTo("[1, 3]");
    }

    @Test
    void remove_and_add2() {
        list.add(1);
        list.add(2);
        list.remove(0);
        list.add(3);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains(1)).isFalse();
        assertThat(list.toString()).isEqualTo("[2, 3]");
    }

    @Test
    void remove_and_add3() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        list.add(4);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.contains(2)).isFalse();
        assertThat(list.toString()).isEqualTo("[1, 3, 4]");
    }

    @Test
    void add_first_and_last() {
        list.add(1);
        list.add(2);
        list.addFirst(0);
        list.addLast(3);

        assertThat(list.size()).isEqualTo(4);
        assertThat(list.toString()).isEqualTo("[0, 1, 2, 3]");
    }
}