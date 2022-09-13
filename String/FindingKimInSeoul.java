public class FindingKimInSeoul {
    public String solution(String[] seoul) {
        String answer = null;
        for (int i=0;i<seoul.length;i++) {
            if ("Kim".equals(seoul[i])) {
                answer = String.format("김서방은 %d에 있다",i);
            }
        }
        return answer;
    }
}
