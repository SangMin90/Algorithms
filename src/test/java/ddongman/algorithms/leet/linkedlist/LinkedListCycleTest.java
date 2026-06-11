package ddongman.algorithms.leet.linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.linkedlist.domain.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListCycleTest {

    private LinkedListCycle sut;

    @BeforeEach
    void setUp() {
        sut = new LinkedListCycle();
    }

    @Test
    void case1() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

//        boolean result = sut.hasCycle(head);
        boolean result = sut.hasCycle2(head);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;

//        boolean result = sut.hasCycle(head);
        boolean result = sut.hasCycle2(head);

        assertThat(result).isTrue();
    }

    @Test
    void case3() {
        ListNode head = new ListNode(1);

//        boolean result = sut.hasCycle(head);
        boolean result = sut.hasCycle2(head);

        assertThat(result).isFalse();
    }
}