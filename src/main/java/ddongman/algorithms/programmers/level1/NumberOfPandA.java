package ddongman.algorithms.programmers.level1;

public class NumberOfPandA {
    boolean solution(String s) {
        s = s.toLowerCase();
        int orgLen = s.length();

        s = s.replaceAll("p","");
        int lenWithoutP = s.length();

        s = s.replaceAll("y","");
        int lenWithoutY = s.length();

        boolean answer = false;
        if ((orgLen + lenWithoutY) == 2 * lenWithoutP) {
            answer = true;
        }

        return answer;
    }
}