package ddongman.algorithms.programmers.level1;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toString(arr1[i] | arr2[i], 2).replaceAll("0"," ").replaceAll("1","#");
            while (answer[i].length() < n) {
                answer[i] = " " + answer[i];
            }
        }
        return answer;
    }
}