package ddongman.algorithms.doit.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GitaLessonTest {

    private GitaLesson sut;

    @BeforeEach
    void setUp() {
        sut = new GitaLesson();
    }

    @Test
    void case1() {
        int n = 9;
        int m = 3;
        int[] len = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int result = sut.solution(n, m, len);

        Assertions.assertThat(result).isEqualTo(17);
    }
}