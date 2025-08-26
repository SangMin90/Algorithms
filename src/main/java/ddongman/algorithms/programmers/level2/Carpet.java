package ddongman.algorithms.programmers.level2;

public class Carpet {
    public static void main(String[] args) {
        Carpet sample = new Carpet();
        int[] answer = sample.solution(24, 24);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public int[] solution(int brown, int yellow) {
        int n = brown + yellow;
        int[] answer = getCarpetSize(yellow, n);
        return answer;
    }

    private int[] getCarpetSize(int yellow, int n) {
        for (int height = 2; height*height<= n; height++) {
            int width = n / height;
            if (n % height == 0) {
                if ((height - 2) * (width - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        return null;
    }
}
