package ddongman.algorithms.leet.graph;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinimumGeneticMutationCalculatorTest {

    private MinimumGeneticMutationCalculator sut;

    @BeforeEach
    void setUp() {
        sut = new MinimumGeneticMutationCalculator();
    }

    @Test
    void case1() {
        String startGene = "AACCGGTT", endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};

        int result = sut.minMutation(startGene, endGene, bank);

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        String startGene = "AACCGGTT", endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        int result = sut.minMutation(startGene, endGene, bank);

        Assertions.assertThat(result).isEqualTo(2);
    }
}