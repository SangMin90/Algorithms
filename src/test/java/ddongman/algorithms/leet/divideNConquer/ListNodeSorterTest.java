package ddongman.algorithms.leet.divideNConquer;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.linkedlist.domain.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListNodeSorterTest {

    private ListNodeSorter sut;

    @BeforeEach
    void setUp() {
        sut = new ListNodeSorter();
    }

    @Test
    void case1() {
        ListNode head = new ListNode(4,
            new ListNode(
                2,
                new ListNode(1,new ListNode(3))
            )
        );

        ListNode result = sut.sortList(head);

        assertThat(result).isEqualTo(
            new ListNode(1,
                new ListNode(
                    2,
                    new ListNode(3,new ListNode(4))
                )
            )
        );
    }

    @Test
    void case2() {
        ListNode head = new ListNode(-1,
            new ListNode(
                5,
                new ListNode(3,
                    new ListNode(4, new ListNode(0))
                )
            )
        );

        ListNode result = sut.sortList(head);

        assertThat(result).isEqualTo(
            new ListNode(-1,
                new ListNode(
                    0,
                    new ListNode(3,
                        new ListNode(4, new ListNode(5))
                    )
                )
            )
        );
    }

    @Test
    void case3() {
        ListNode head = null;

        ListNode result = sut.sortList(head);

        assertThat(result).isNull();
    }

    @Test
    void case4() {
        ListNode head = new ListNode(3,
            new ListNode(4,new ListNode(1))
        );

        ListNode result = sut.sortList(head);

        assertThat(result).isEqualTo(
            new ListNode(1,
                new ListNode(3,new ListNode(4))
            )
        );
    }
}