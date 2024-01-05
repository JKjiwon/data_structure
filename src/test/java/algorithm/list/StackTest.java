package algorithm.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackTest {

    Stack<Integer> stack = new Stack<>();

    @BeforeEach
    void init() {
        stack.clear();
    }

    @Test
    void push() {
        stack.push(1);
        stack.push(2);

        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.contains(1)).isTrue();
        assertThat(stack.contains(2)).isTrue();
        assertThat(stack.toString()).isEqualTo("[1, 2]");
    }

    @Test
    void pop() {
        stack.push(1);
        stack.push(2);

        Integer poppedData = stack.pop();

        assertThat(stack.size()).isEqualTo(1);
        assertThat(poppedData).isEqualTo(2);
        assertThat(stack.contains(2)).isFalse();
        assertThat(stack.toString()).isEqualTo("[1]");
    }

    @Test
    void peek() {
        stack.push(1);
        stack.push(2);

        Integer peekedData = stack.peek();

        assertThat(stack.size()).isEqualTo(2);
        assertThat(peekedData).isEqualTo(2);
        assertThat(stack.contains(1)).isTrue();
        assertThat(stack.contains(2)).isTrue();
        assertThat(stack.toString()).isEqualTo("[1, 2]");
    }
}