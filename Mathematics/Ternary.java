public class Ternary {
    public int solution(int n) {
        String s = Integer.toString(n, 3);
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        int answer = Integer.valueOf(sb.toString(), 3);
        return answer;
    }
}
