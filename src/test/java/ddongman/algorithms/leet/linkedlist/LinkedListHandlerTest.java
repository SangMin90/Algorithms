package ddongman.algorithms.leet.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.linkedlist.domain.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListHandlerTest {

    private LinkedListHandler sut;

    @Test
    void case1() {
        ListNode list1 =
            new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 =
            new ListNode(1, new ListNode(3, new ListNode(4)));
        sut = new LinkedListHandler();

        ListNode result = sut.mergeTwoLists(list1, list2);

        assertThat(result).isEqualTo(
            new ListNode(1,
                new ListNode(1,
                    new ListNode(2,
                        new ListNode(3,
                            new ListNode(4,
                                new ListNode(4)
                            )
                        )
                    )
                )
            )
        );
    }

    @Test
    void case2() {
        ListNode list1 = null;
        ListNode list2 = null;
        sut = new LinkedListHandler();

        ListNode result = sut.mergeTwoLists(list1, list2);

        assertThat(result).isNull();
    }

    @Test
    void case3() {
        ListNode list1 = null;
        ListNode list2 = new ListNode(0);
        sut = new LinkedListHandler();

        ListNode result = sut.mergeTwoLists(list1, list2);

        assertThat(result).isEqualTo(new ListNode(0));
    }
}