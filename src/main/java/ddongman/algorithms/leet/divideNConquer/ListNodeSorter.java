package ddongman.algorithms.leet.divideNConquer;

import ddongman.algorithms.leet.linkedlist.domain.ListNode;

public class ListNodeSorter {

    public ListNode sortList(ListNode head) {

        return split(head);
    }

    private ListNode split(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = split(head);
        ListNode right = split(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode();
        ListNode merged = dummy;

        while (left != null && right != null) {

            if (left.val < right.val) {
                merged.next = left;
                left = left.next;
            } else {
                merged.next = right;
                right = right.next;
            }

            merged = merged.next;
        }

        merged.next = left != null ? left : right;

        return dummy.next;
    }


}
