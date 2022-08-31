public class MakingPrimeNumber {
    public int solution(int[] nums) {
        int[] c = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            if ((c.length-i) <= 3) {
                c[i] = 1;
            }
        }
        int answer = 0;
        do {
            int temp = 0;
            for (int i=0;i<c.length;i++) {
                if (c[i] == 1) {
                    temp += nums[i];
                }
            }
            if (isPrime(temp)) {
                answer++;
            }
        } while (nextPermutation(c));

        return answer;
    }
    static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i-1] >= a[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[i-1] >= a[j]) {
            j--;
        }
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        return true;
    }
    static boolean isPrime(int number) {
        for (int i=2;i*i<=number;i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}