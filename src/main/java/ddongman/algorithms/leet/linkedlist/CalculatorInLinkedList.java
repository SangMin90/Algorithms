package ddongman.algorithms.leet.linkedlist;

import ddongman.algorithms.leet.linkedlist.domain.ListNode;
import java.util.ArrayList;
import java.util.List;

public class CalculatorInLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int len1 = length(l1);
        int len2 = length(l2);
        if (len1 > len2) {
            int temp = len1;
            len1 = len2;
            len2 = temp;

            ListNode tempNode = l1;
            l1 = l2;
            l2 = tempNode;
        }

        List<Integer> eleOfSum = new ArrayList<>();

        int carry = 0;
        for (int i = 0; i < len1; i++) {
            eleOfSum.add((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        for (int i = len1; i < len2; i++) {
            eleOfSum.add((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;

            l2 = l2.next;
        }

        if (carry > 0) {
            eleOfSum.add(carry);
        }

        ListNode root = new ListNode();

        convertToListNode(root, 0, eleOfSum);

        return root;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {

            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            curr.next = new ListNode((val + carry) % 10);
            curr = curr.next;

            carry = (val + carry) / 10;
        }

        return dummy.next;
    }

    private void convertToListNode(ListNode head, int idx, List<Integer> eleOfSum) {
        head.val = eleOfSum.get(idx);

        if (idx < eleOfSum.size() - 1) {
            convertToListNode(head.next = new ListNode(), idx + 1, eleOfSum);
        }
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }
}
