package ddongman.algorithms.leet.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinStackTest {

    private MinStack sut;

    @BeforeEach
    void setUp() {
        sut = new MinStack();
    }

    @Test
    void case1() {
//        sut.push(-2);
//        sut.push(0);
//        sut.push(-3);
//        sut.push2(-2);
//        sut.push2(0);
//        sut.push2(-3);
        sut.push3(-2);
        sut.push3(0);
        sut.push3(-3);

//        int result1 = sut.getMin();
//        sut.pop();
//        int result2 = sut.top();
//        int result3 = sut.getMin();
//        int result1 = sut.getMin2();
//        sut.pop2();
//        int result2 = sut.top2();
//        int result3 = sut.getMin2();
        int result1 = sut.getMin3();
        sut.pop3();
        int result2 = sut.top3();
        int result3 = sut.getMin3();

        assertThat(result1).isEqualTo(-3);
        assertThat(result2).isEqualTo(0);
        assertThat(result3).isEqualTo(-2);
    }
}