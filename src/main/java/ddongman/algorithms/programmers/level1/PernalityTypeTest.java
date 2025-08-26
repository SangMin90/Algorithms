package ddongman.algorithms.programmers.level1;

import java.util.*;

public class PernalityTypeTest {
    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

        List<Character> indicators = new ArrayList<>(Arrays.asList('R','T','C','F','J','M','A','N'));

        int[] scores = new int[indicators.size()];

        for (int i=0;i<survey.length;i++) {
            char type1 = survey[i].charAt(0);
            char type2 = survey[i].charAt(1);

            int choice = choices[i];

            if (choice < 4) {
                int cnt = indicators.indexOf(type1);
                scores[cnt] += 4 - choice;
            } else if (choice > 4) {
                int cnt = indicators.indexOf(type2);
                scores[cnt] += choice - 4;
            }
        }

        String answer = "";

        for (int i=0;i<scores.length;i+=2) {
            if (scores[i] > scores[i+1]) {
                answer += String.valueOf(indicators.get(i));
            } else if (scores[i] < scores[i+1]) {
                answer += String.valueOf(indicators.get(i+1));
            } else {
                if (indicators.get(i).compareTo(indicators.get(i+1)) < 0) {
                    answer += String.valueOf(indicators.get(i));
                } else if (indicators.get(i).compareTo(indicators.get(i+1)) > 0) {
                    answer += String.valueOf(indicators.get(i+1));
                }
            }
        }

        System.out.println(answer);
    }
}
