package ddongman.algorithms.doit.combination;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    private final Factorial factorial;
    private final int N;
    private final boolean[] visited;

    public Permutation(int N) {

        factorial = new Factorial(N - 1);
        visited = new boolean[N + 1];

        this.N = N;
    }
    
    public long findOrderOf(int[] permutation) {

        long order = 1;

        for (int i = 0; i < N; i++) {
            int groupOrder = findGroupOrderOf(permutation[i]);
            visited[permutation[i]] = true;

            order += (groupOrder - 1) * factorial.factorial(N - i - 1);
        }

        return order;
    }

    private int findGroupOrderOf(int element) {

        int index = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                index++;
            }

            if (i == element) {
                return index;
            }
        }

        throw new IllegalArgumentException("해당 숫자의 그룹 내 순서를 파악할 수 없습니다.");
    }
    
    public int[] findKthPermutation(long K, int N) {

        List<Integer> permutation = new ArrayList<>();
        long orderInIndex = K;

        for (int i = N; i >= 1; i--) {
            int groupOrder = findGroupOrderOf(i, orderInIndex);

            int element = findElementOf(groupOrder);
            permutation.add(element);
            visited[element] = true;

            orderInIndex = findNext(orderInIndex, i);
        }

        return permutation.stream().mapToInt(i -> i).toArray();
    }

    private int findElementOf(int groupOrder) {

        int index = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                index++;
            }

            if (groupOrder == index) {
                return i;
            }
        }

        throw new IllegalArgumentException("해당 순서에 해당하는 값이 존재하지 않습니다.");
    }

    public int findGroupOrderOf(int index, long K) {

        return (int) ((K - 1) / factorial.factorial(index - 1)) + 1;
    }

    public long findNext(long orderInIndex, int index) {

        return (orderInIndex - 1) % factorial.factorial(index - 1) + 1;
    }

    static class Factorial {

        private final long[] F;

        public Factorial(int N) {
            F = new long[N + 1];

            F[0] = 1;
            for (int i = 1; i <= N; i++) {
                F[i] = i * F[i - 1];
            }
        }

        public long factorial(int K) {
            return F[K];
        }
    }
}
