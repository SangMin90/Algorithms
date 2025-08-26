package ddongman.algorithms.programmers.level1;

public class RepeatWithSuBak {
    public String solution(int n) {
        String pattern = "수박";
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n/2;i++) {
            sb.append(pattern);
        }

        if (n % 2 == 1) {
            sb.append(pattern.charAt(0));
        }

        return sb.toString();
    }
}
