package ddongman.algorithms.programmers.level1;

public class Ternary {
    public int solution(int n) {
        String s = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return Integer.valueOf(sb.toString(), 3);
    }
}
