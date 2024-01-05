package algorithm.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueueTest {

    Queue<Integer> queue = new LinkedList<>();

    @BeforeEach
    void init() {
        queue.clear();
    }

    @Test
    void offer() {
        // when
        queue.offer(1);
        queue.offer(2);


        // then
        assertThat(queue.size()).isEqualTo(2);
        assertThat(queue.contains(1)).isTrue();
        assertThat(queue.contains(2)).isTrue();
        assertThat(queue.toString()).isEqualTo("[1, 2]");
    }

    @Test
    void poll() {
        //given
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        // when
        queue.poll();
        queue.poll();

        // then
        assertThat(queue.size()).isEqualTo(2);
        assertThat(queue.contains(1)).isFalse();
        assertThat(queue.contains(2)).isFalse();
        assertThat(queue.toString()).isEqualTo("[3, 4]");
    }

    @Test
    void peek() {
        queue.offer(1);
        queue.offer(2);

        Integer peekData = queue.peek();

        assertThat(peekData).isEqualTo(1);
        assertThat(queue.size()).isEqualTo(2);
    }
}