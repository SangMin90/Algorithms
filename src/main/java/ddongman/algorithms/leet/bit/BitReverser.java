package ddongman.algorithms.leet.bit;

public class BitReverser {

    public int reverseBits(int n) {

        int start = 0;
        int end = 31;
        while (start <= end) {
            int firstNum = (n & (1 << end)) > 0 ? 1 : 0;
            int lastNum = (n & (1 << start)) > 0 ? 1 : 0;

            if (firstNum == 1) {
                n |= (firstNum << start);
            } else {
                n &= ~(1 << start);
            }

            if (lastNum == 1) {
                n |= (lastNum << end);
            } else {
                n &= ~(1 << end);
            }
            start++;
            end--;
        }

        return n;
    }

    public int reverseBits2(int n) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) | (n & 1);
            n >>= 1;
        }

        return ans;
    }

    public int reverseBits3(int n) {

        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | (n & 0x00ff00ff) << 8;
        n = ((n & 0xf0f0f0f0) >>> 4) | (n & 0x0f0f0f0f) << 4;
        n = ((n & 0xcccccccc) >>> 2) | (n & 0x33333333) << 2;
        n = ((n & 0xaaaaaaaa) >>> 1) | (n & 0x55555555) << 1;

        return n;
    }

    public int reverseBits4(int n) {

        return divide(n, 32);
    }

    private int divide(int n, int len) {

        if (len == 1) {
            return n & 1;
        }

        int mid = len >> 1;
        int lo = n >> mid;
        int hi = n & ((1 << mid) - 1);

        return divide(lo, mid) | (divide(hi, mid) << mid);
    }
}
