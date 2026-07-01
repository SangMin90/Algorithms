package ddongman.algorithms.leet.math;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        int len = (int) Math.log10(x) + 1;
        int mid = (len - 1) / 2;

        int index = 0;
        while (index <= mid) {

            int num = x % 10;
            x /= 10;

            if (len % 2 == 0 || index != mid) {
                queue.push(num);
            }

            index++;
        }

        while (index <= len - 1) {

            if (queue.pop() != x % 10) {
                return false;
            }

            x /= 10;
            index++;
        }

        return queue.isEmpty();
    }

    public boolean isPalindrome2(int x) {

        if (x < 0) {
            return false;
        }

        int a = x;
        int b = 0;

        while (a > 0) {
            b = b * 10 + a % 10;
            a /= 10;
        }

        return x == b;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        while (reversed < x) {

            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return x == reversed || x == reversed / 10;
    }
}
