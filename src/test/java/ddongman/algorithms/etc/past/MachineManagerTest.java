package ddongman.algorithms.etc.past;

import ddongman.algorithms.etc.past.prefixSum.MachineManager;
import ddongman.algorithms.etc.past.domain.ProductLine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MachineManagerTest {

    private MachineManager sut;

    @Test
    void case1() {
        int N = 6;
        int Q = 5;
        int K = 2;
        int[] machines = new int[]{3, 7, 10, 13, 17, 20};
        ProductLine[] lines = new ProductLine[]{
                new ProductLine(1, 10),
                new ProductLine(3, 9),
                new ProductLine(4, 23),
                new ProductLine(12, 19),
                new ProductLine(3, 15),
        };
        sut = new MachineManager(N, lines, machines);

        int result = sut.scrap(K);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void case2() {
        int N = 10;
        int Q = 6;
        int K = 0;
        int[] machine = new int[]{1, 5, 10, 20, 29, 40, 55, 64, 71, 79};
        ProductLine[] lines = {
                new ProductLine(7, 60),
                new ProductLine(20, 77),
                new ProductLine(1, 21),
                new ProductLine(5, 55),
                new ProductLine(10, 71),
                new ProductLine(22, 27),
        };
        sut = new MachineManager(N, lines, machine);

        int result = sut.scrap(K);

        assertThat(result).isEqualTo(20);
    }

}