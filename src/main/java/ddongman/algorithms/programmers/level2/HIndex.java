package ddongman.algorithms.programmers.level2;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        HIndex sample = new HIndex();
        System.out.println(sample.solution(new int[]{10, 8, 5, 4, 3}));
    }
    public int solution(int[] citations) {

        return findHIndex(citations);
    }
    private int findHIndex(int[] c) {
        Arrays.sort(c);

        int[] cited = judgeCited(c);

        return getHIndex(c, cited);
    }

    private int getHIndex(int[] c, int[] cited) {
        int x = c.length + 1;
        int y = 0;

        for (int i = c[c.length - 1]; i >= 0; i--) {
            if (cited[i] > 0) {
                x -= cited[i];

                y += cited[i];
            }
            if (i >= x && i <= y) {
                return i;
            }
        }
        return 0;
    }

    private int[] judgeCited(int[] c) {
        int[] cited = new int[10001];

        for (int i : c) {
            cited[i] += 1;
        }

        return cited;
    }
}
