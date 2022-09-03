import java.util.*;
import java.util.stream.Collectors;

public class SampleTest {
    public int[] solution(int[] answers) {
        int[] correct = new int[3];

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        for (int i=0;i<answers.length;i++) {
            if (answers[i] == a[i % a.length]) {
                correct[0]++;
            }
            if (answers[i] == b[i % b.length]) {
                correct[1]++;
            }
            if (answers[i] == c[i % c.length]) {
                correct[2]++;
            }
        }

        int max = 0;

        for (int each:correct) {
            if (max < each) {
                max = each;
            }
        }

        List<Integer> temp = new ArrayList<>();

        for (int i=0;i<correct.length;i++) {
            if (correct[i] == max) {
                temp.add(i+1);
            }
        }

        int[] answer = temp.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}