package ddongman.algorithms.leet.intervals;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RangeSummaryTest {

    private RangeSummary sut;

    @BeforeEach
    void setUp() {
        sut = new RangeSummary();
    }

    @Test
    void case1() {
        int[] nums = {0,1,2,4,5,7};

        List<String> result = sut.summaryRanges(nums);

        assertThat(result).isEqualTo(List.of("0->2","4->5","7"));
    }

    @Test
    void case2() {
        int[] nums = {0,2,3,4,6,8,9};

        List<String> result = sut.summaryRanges(nums);

        assertThat(result).isEqualTo(List.of("0","2->4","6","8->9"));
    }

    @Test
    void case3() {
        int[] nums = {0,1,2,4,5,7};

        List<String> result = sut.summaryRanges2(nums);

        assertThat(result).isEqualTo(List.of("0->2","4->5","7"));
    }

    @Test
    void case4() {
        int[] nums = {0,2,3,4,6,8,9};

        List<String> result = sut.summaryRanges2(nums);

        assertThat(result).isEqualTo(List.of("0", "2->4", "6", "8->9"));
    }

    @Test
    void case5() {
        int[] nums = {0,1,2,4,5,7};

        List<String> result = sut.summaryRanges3(nums);

        assertThat(result).isEqualTo(List.of("0->2","4->5","7"));
    }

    @Test
    void case6() {
        int[] nums = {0,2,3,4,6,8,9};

        List<String> result = sut.summaryRanges3(nums);

        assertThat(result).isEqualTo(List.of("0", "2->4", "6", "8->9"));
    }
}