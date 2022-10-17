public class GcdOfNumbers {
    public static void main(String[] args) {
        GcdOfNumbers sample = new GcdOfNumbers();
        System.out.println(sample.solution(new int[]{2, 6, 8, 14}));
    }
    public int solution(int[] arr) {

        int lcm = arr[0];

        for (int i = 1; i <= arr.length - 1; i++) {
            lcm = getLCM(arr[i], lcm);
        }

        return lcm;
    }

    int getLCM(int a, int b) {
        int gcd = getGCD(a, b);
        return a * b / gcd;
    }

    int getGCD(int a, int b) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
