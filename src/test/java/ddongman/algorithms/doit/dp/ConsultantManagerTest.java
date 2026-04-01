package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsultantManagerTest {

    private ConsultantManager sut;

    @Test
    void case1() {
        int N = 7;
        sut = new ConsultantManager(N);
        sut.addConsultation(3, 10);
        sut.addConsultation(5, 20);
        sut.addConsultation(1, 10);
        sut.addConsultation(1, 20);
        sut.addConsultation(2, 15);
        sut.addConsultation(4, 40);
        sut.addConsultation(2, 200);

        int resign = sut.calculateMaxProfits();

        assertThat(resign).isEqualTo(45);
    }

    @Test
    void case2() {
        int N = 10;
        sut = new ConsultantManager(N);

        sut.addConsultation(1, 1);
        sut.addConsultation(1, 2);
        sut.addConsultation(1, 3);
        sut.addConsultation(1, 4);
        sut.addConsultation(1, 5);
        sut.addConsultation(1, 6);
        sut.addConsultation(1, 7);
        sut.addConsultation(1, 8);
        sut.addConsultation(1, 9);
        sut.addConsultation(1, 10);

        int resign = sut.calculateMaxProfits();

        assertThat(resign).isEqualTo(55);
    }

    @Test
    void case3() {
        int N = 10;
        sut = new ConsultantManager(N);
        sut.addConsultation(5, 10);
        sut.addConsultation(5, 9);
        sut.addConsultation(5, 8);
        sut.addConsultation(5, 7);
        sut.addConsultation(5, 6);
        sut.addConsultation(5, 10);
        sut.addConsultation(5, 9);
        sut.addConsultation(5, 8);
        sut.addConsultation(5, 7);
        sut.addConsultation(5, 6);

        int resign = sut.calculateMaxProfits();

        assertThat(resign).isEqualTo(20);
    }

    @Test
    void case4() {
        int N = 10;
        sut = new ConsultantManager(N);
        sut.addConsultation(5, 50);
        sut.addConsultation(4, 40);
        sut.addConsultation(3, 30);
        sut.addConsultation(2, 20);
        sut.addConsultation(1, 10);
        sut.addConsultation(1, 10);
        sut.addConsultation(2, 20);
        sut.addConsultation(3, 30);
        sut.addConsultation(4, 40);
        sut.addConsultation(5, 50);

        int resign = sut.calculateMaxProfits();

        assertThat(resign).isEqualTo(90);
    }
}