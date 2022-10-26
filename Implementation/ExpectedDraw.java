public class ExpectedDraw {
    public static void main(String[] args) {
        ExpectedDraw sample = new ExpectedDraw();
        System.out.println(sample.solution(8,8,7));
    }
    public int solution(int n, int a, int b) {
        return getRoundCount(n, a, b);
    }

    private int getRoundCount(int n, int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (!isOtherSide(n, a, b)) {
            n /= 2;
            a = (a - n) > 0 ? (a - n) : a;
            b = (b - n) > 0 ? (b - n) : b;
        }

        int roundCount = getCount(n);

        return roundCount;
    }

    private int getCount(int n) {
        int count = 0;
        while (n > 1) {
            n /= 2;
            count++;
        }
        return count;
    }

    private boolean isOtherSide(int n, int a, int b) {
        return (a - n / 2) <= 0 && (b - n / 2) > 0;
    }
}
