import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NCombinationTwoAndSum {
    public int[] solution(int[] numbers) {
        int[] c = new int[numbers.length];
        for (int i=0;i<c.length;i++) {
            if ((c.length - i) <= 2) {
                c[i] = 1;
            }
        }
        Set<Integer> temp = new HashSet<>();
        do {
            int sum = 0;
            for (int i=0;i<c.length;i++) {
                if (c[i] == 1) {
                    sum += numbers[i];
                }
            }
            temp.add(Integer.valueOf(sum));
        } while (nextPermutation(c));
        int[] answer = temp.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
    static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i-1] >= a[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length - 1;
        while (a[i-1] >= a[j]) {
            j--;
        }
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;
        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
