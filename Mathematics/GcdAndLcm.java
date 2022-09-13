public class GcdAndLcm {
    public static void main(String[] args) {
        GcdAndLcm sample = new GcdAndLcm();
        sample.solution(2, 5);
    }
    public int[] solution(int n, int m) {
        int smallNumber = n < m ? n : m;
        int bigNumber = n > m ? n : m;
        int gcd = 0;
        for (int i=1;i<=smallNumber;i++) {
            if (smallNumber % i == 0 && bigNumber % i == 0) {
                gcd = i;
            }
        }
        int lcm = n * m / gcd;
        int[] answer = {gcd, lcm};
        return answer;
    }
}
