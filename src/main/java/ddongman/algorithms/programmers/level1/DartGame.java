package ddongman.algorithms.programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DartGame {

    String bonusOptions = "SDT";
    int[] scores;

    public int solution(String dartResult) {
        scores = Arrays.stream(("0-"+dartResult).split("[^0-9]")).filter(s -> !s.isEmpty()).mapToInt(Integer::valueOf).toArray();

        List<String> events = Arrays.stream(dartResult.split("\\d{1,2}")).toList();

        for (int i = 1; i <= 3; i++) {
            String[] event = events.get(i).split("");
            for (String each : event) {
                if (bonusOptions.contains(each)) {
                    scores[i] = getBonus(scores[i], each);
                } else {
                    applyOption(each, i);
                }
            }
        }

        return Arrays.stream(scores).sum();
    }

    int getBonus(int score, String bonusId) {
        int bonus = 1;
        int size = bonusOptions.indexOf(bonusId)+1;
        for (int i = 0; i < size; i++) {
            bonus *= score;
        }
        return bonus;
    }

    void applyOption(String each, int idx) {
        if (each.equals("#")) {
            scores[idx] *= -1;
        } else {
            scores[idx] *= 2;
            scores[idx - 1] *= 2;
        }
    }
}