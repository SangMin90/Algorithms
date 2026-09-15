package ddongman.algorithms.leet.contest.weekly519;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromicFinder {

    static List<Long> palindromicOddNumber = new ArrayList<>();
    static List<Long> palindromicEvenNumber = new ArrayList<>();

    static {
        for (int len = 1; len < 10; len++) {
            int half = (len + 1) / 2;
            long start = pow(10, half - 1);
            long end = pow(10, half);

            for (long i = start; i < end; i++) {
                String s = Long.toString(i);
                String r = new StringBuilder(s).reverse().toString();

                long palindromicNumber =
                    len % 2 == 0 ? Long.valueOf(s + r) : Long.valueOf(s + r.substring(1));

                if (palindromicNumber % 2 == 0) {
                    palindromicEvenNumber.add(palindromicNumber);
                } else {
                    palindromicOddNumber.add(palindromicNumber);
                }
            }
        }
    }

    public long minOperations(int[] nums) {

        long count = 0;

        for (int num : nums) {

            if (num % 2 == 0) {
                count += getMinDiff(palindromicEvenNumber, num) / 2;
            } else {
                count += getMinDiff(palindromicOddNumber, num) / 2;
            }
        }

        return count;
    }

    private static long pow(int base, int digit) {
        long result = 1;

        while (digit-- > 0) {
            result *= 10;
        }

        return result;
    }

    private long getMinDiff(List<Long> palindromicNumbers, long number) {

        int index = Collections.binarySearch(palindromicNumbers, number);

        if (index >= 0) {
            return 0;
        }

        index = -index - 1;

        if (index == 0) {
            return palindromicNumbers.get(index) - number;
        }

        if (index == palindromicNumbers.size()) {
            return number - palindromicNumbers.get(index - 1);
        }

        return Math.min(palindromicNumbers.get(index) - number,
            number - palindromicNumbers.get(index - 1));
    }
}
