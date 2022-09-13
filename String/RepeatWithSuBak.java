public class RepeatWithSuBak {
    public String solution(int n) {
        String pattern = "수박";
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n/2;i++) {
            sb.append(pattern);
        }
        if (n % 2 == 1) {
            sb.append(String.valueOf(pattern.charAt(0)));
        }
        String answer = sb.toString();
        return answer;
    }
}
