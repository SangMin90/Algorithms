package ddongman.algorithms.leet.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.linkedlist.domain.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorInLinkedListTest {

    private CalculatorInLinkedList sut;

    @BeforeEach
    public void setUp() {
        sut = new CalculatorInLinkedList();
    }

    @Test
    void case1() {
        ListNode l1 = new ListNode(
            2,
            new ListNode(
                4,
                new ListNode(3)
            )
        );
        ListNode l2 = new ListNode(
            5,
            new ListNode(
                6,
                new ListNode(4)
            )
        );

//        ListNode result = sut.addTwoNumbers(l1, l2);
        ListNode result = sut.addTwoNumbers2(l1, l2);

        assertThat(result).isEqualTo(
            new ListNode(
                7,
                new ListNode(
                    0,
                    new ListNode(8)
                )
            )
        );
    }

    @Test
    void case2() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

//        ListNode result = sut.addTwoNumbers(l1, l2);
        ListNode result = sut.addTwoNumbers2(l1, l2);

        assertThat(result).isEqualTo(
            new ListNode(0)
        );
    }

    @Test
    void case3() {
        ListNode l1 =
            new ListNode(9,
                new ListNode(9,
                    new ListNode(9,
                        new ListNode(9,
                            new ListNode(9,
                                new ListNode(9,
                                    new ListNode(9)
                                )
                            )
                        )
                    )
                )
            );
        ListNode l2 =
            new ListNode(9,
                new ListNode(9,
                    new ListNode(9,
                        new ListNode(9)
                    )
                )
            );

//        ListNode result = sut.addTwoNumbers(l1, l2);
        ListNode result = sut.addTwoNumbers2(l1, l2);

        assertThat(result).isEqualTo(
            new ListNode(8,
                new ListNode(9,
                    new ListNode(9,
                        new ListNode(9,
                            new ListNode(0,
                                new ListNode(0,
                                    new ListNode(0,
                                        new ListNode(1)
                                    )
                                )
                            )
                        )
                    )
                )
            )
        );
    }
}