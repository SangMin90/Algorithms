import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class Tuple {
    public int[] solution(String s) {
        String[] tuples = s.split("},");
        for (int i = 0; i < tuples.length; i++) {
            tuples[i] = tuples[i].replaceAll("[^0-9|,]", "");
        }

        Arrays.sort(tuples, Comparator.comparing(String::length));

        LinkedHashSet<Integer> intArray = getArray(tuples);

        return intArray.stream().mapToInt(Integer::intValue).toArray();
    }

    private LinkedHashSet<Integer> getArray(String[] tuples) {
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();

        for (String temp : tuples) {
            String[] split2 = temp.split(",");
            for (String s1 : split2) {
                answer.add(Integer.parseInt(s1));
            }
        }
        return answer;
    }
}
