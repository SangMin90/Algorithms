package ddongman.algorithms.programmers.level1;

import java.util.Arrays;

public class IntegerDescendingOrder {
    public long solution(long n) {
        int length = String.valueOf(n).length();
        long[] longArray = new long[length];
        for (int i=0;i<length;i++) {
            longArray[i] = n % 10;
            n /= 10;
        }
        Arrays.sort(longArray);
        StringBuilder temp = new StringBuilder();
        for (int i=length-1;i>=0;i--) {
            temp.append(longArray[i]);
        }
        return Long.parseLong(temp.toString());
    }
}
