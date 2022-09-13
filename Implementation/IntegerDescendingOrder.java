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
        String temp = "";
        for (int i=length-1;i>=0;i--) {
            temp += String.valueOf(longArray[i]);
        }
        long answer = Long.valueOf(temp);
        return answer;
    }
}
