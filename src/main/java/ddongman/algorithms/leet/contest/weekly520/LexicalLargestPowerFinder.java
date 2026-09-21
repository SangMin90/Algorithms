package ddongman.algorithms.leet.contest.weekly520;

import java.util.ArrayList;
import java.util.List;

public class LexicalLargestPowerFinder {

    public int[] largestPower(int[] nums) {

        final int totalBits = 15;

        List<Long> initGroup = new ArrayList<>();
        for (int num : nums) {
            initGroup.add(num & 0xFFFFFFFFL);
        }

        Node groups = new Node(initGroup);

        int[] bits = new int[totalBits];
        int bit = 0;
        while (bit < totalBits) {

            Node curr = groups;
            while (curr != null) {

                List<Long> currElements = new ArrayList<>();
                List<Long> nextElements = new ArrayList<>();
                for (int index = 0; index < curr.elements.size(); index++) {
                    long element = curr.elements.get(index);
                    if ((element & (1L << (totalBits - bit - 1))) == 0) {
                        nextElements.add(element);
                    } else {
                        currElements.add(element);
                    }
                }

                if (currElements.isEmpty()) {
                    break;
                }

                if (nextElements.isEmpty()) {
                    bits[bit] += currElements.size();
                    curr = curr.next;
                    continue;
                }

                Node nextGroup = new Node(nextElements);
                curr.elements = currElements;
                nextGroup.next = curr.next;
                curr.next = nextGroup;

                bits[bit] += curr.elements.size();
                break;
            }

            bit++;
        }

        return bits;
    }

    static class Node {
        List<Long> elements;
        Node next;

        Node(List<Long> elements) {
            this.elements = elements;
        }
    }

    public int[] largestPower2(int[] nums) {
        List<List<Long>> groups = new ArrayList<>();

        List<Long> initGroup = new ArrayList<>();
        for (int num : nums) {
            initGroup.add(num & 0xFFFFFFFFL);
        }

        groups.add(initGroup);

        int n = 15;
        int[] power = new int[n];
        for (int bit = 0; bit < n; bit++) {

            for (int i = 0; i < groups.size(); i++) {

                List<Long> zero = new ArrayList<>();
                List<Long> one = new ArrayList<>();

                List<Long> currGroup = groups.get(i);
                for (Long element : currGroup) {
                    if ((element & (1L << (n - bit - 1))) > 0) {
                        one.add(element);
                    } else {
                        zero.add(element);
                    }
                }

                if (one.isEmpty()) {
                    break;
                }

                if (zero.isEmpty()) {
                    power[bit] += one.size();
                    continue;
                }

                groups.set(i, one);
                groups.add(i + 1, zero);

                power[bit] += one.size();
                break;
            }
        }

        return power;
    }
}
