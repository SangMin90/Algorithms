package ddongman.algorithms.leet.linkedlist;

import ddongman.algorithms.leet.linkedlist.domain.ListNode;

public class LinkedListCycle {

    private static final int MAX_COUNT = 10_000;

    public boolean hasCycle(ListNode head) {

        int count = 0;

        while (head != null) {
            head = head.next;
            count++;

            if (count > MAX_COUNT) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {

        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;

            if (walker == runner) {
                return true;
            }
        }

        return false;
    }
}
