import java.util.ArrayList;
import java.util.List;

public class MinNumberElimination {
    public static void main(String[] args) {
        MinNumberElimination sample = new MinNumberElimination();
        System.out.println(sample.solution(new int[]{10}));
    }
    public int[] solution(int[] arr) {
        List<Integer> integerList = new ArrayList<>(arr.length);
        int min = Integer.MAX_VALUE;
        for (int num:arr) {
            if (min > num) {
                min = num;
            }
            integerList.add(Integer.valueOf(num));
        }

        integerList.remove(Integer.valueOf(min));

        int[] answer;

        if (integerList.isEmpty()) {
            answer = new int[]{-1};
        } else {
            answer = integerList.stream().mapToInt(i -> i).toArray();
        }

        return answer;
    }
}
