package ddongman.algorithms.leet.contest.weekly517;

public class IntegerArrayHandler {

    private int[] visited = new int[101];

    public int countSpecialIntegers(int[] nums) {

        int start = 0;
        int end = 0;
        while (start <= end && end < nums.length) {
            if (nums[start] == nums[end]) {
                end++;
            } else {
                visited[nums[start]]++;

                start = end;
            }
        }

        visited[nums[start]]++;

        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                count++;
            }
        }

        return count;
    }

    public int sumDecoded(long[] nums) {

        final long MODULO = 1_000_000_007L;

        long sum = 0;
        for (long num : nums) {
            int width = (int) (num % 10);
            long d = num / 10;

            String str = String.valueOf(d);

            long x = Long.parseLong(str.substring(0, width));
            long y = Long.parseLong(str.substring(width));

            long decodedNum = 1;
            if (x == 1 || y == 0) {
                sum = (sum + decodedNum) % MODULO;
                continue;
            }

            while (y > 0) {

                if ((y & 1) == 1) {
                    decodedNum = ((decodedNum % MODULO) * (x % MODULO)) % MODULO;
                }

                x = ((x % MODULO) * (x % MODULO)) % MODULO;
                y /= 2;
            }

            sum = (sum + decodedNum) % MODULO;
        }

        return (int) sum;
    }
}
