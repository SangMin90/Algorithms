package ddongman.algorithms.programmers.level1;

public class CollatzConjecture {
    public static void main(String[] args) {
        CollatzConjecture sample = new CollatzConjecture();
        System.out.println(sample.solution(1));
    }

    public int solution(int num) {
        int cnt = 0;
        long temp = num;
        while (temp != 1) {
            if (temp % 2 == 0) {
                temp /= 2;
            } else {
                temp *= 3;
                temp++;
            }
            cnt++;
        }
        int answer = cnt <= 500 ? cnt : -1;
        return answer;
    }
}
