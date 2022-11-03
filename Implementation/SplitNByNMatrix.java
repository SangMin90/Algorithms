public class SplitNByNMatrix {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];

        for (long i = left; i <= right; i++) {
            int x = (int) (i / n);
            int y = (int) (i % n);

            answer[(int) (i - left)] = x > y ? x + 1 : y + 1;
        }

        return answer;
    }
}
