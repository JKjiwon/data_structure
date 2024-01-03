package algorithm.list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayListTest {

    @Test
    void add() {
        // given & when
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        // then
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains(1)).isTrue();
        assertThat(list.contains(2)).isTrue();
        assertThat(list.toString()).isEqualTo("[1, 2]");
    }

    @Test
    void add_at() {
        // given
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        // when
        list.add(1, 3);
        list.add(1, 4);

        // then
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.contains(1)).isTrue();
        assertThat(list.contains(2)).isTrue();
        assertThat(list.contains(3)).isTrue();
        assertThat(list.contains(4)).isTrue();
        assertThat(list.toString()).isEqualTo("[1, 4, 3, 2]");
    }

    @Test
    void get() {
        // given
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        // when & then
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
    }

    @Test
    void remove() {
        //given
        ArrayList<Integer> list = new ArrayList<>();
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
    void remove_at() {
        //given
        ArrayList<Integer> list = new ArrayList<>();
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
}