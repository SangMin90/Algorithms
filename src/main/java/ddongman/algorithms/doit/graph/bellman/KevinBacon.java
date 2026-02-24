package ddongman.algorithms.doit.graph.bellman;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KevinBacon {

    private final static int INF = 500_000;

    public int solution(int N, int M, int[][] graph) {
        BellmanFord bellmanFord = new BellmanFord(N, graph);
        bellmanFord.bellmanFord(N);

        int[][] cost = bellmanFord.getCost();

        return findWinner(N, cost);
    }

    private int findWinner(int N, int[][] cost) {
        return IntStream.rangeClosed(1, N)
                .boxed()
                .collect(Collectors.toMap(num -> num, num -> Arrays.stream(cost[num]).sum()))
                .entrySet()
                .stream()
                .min((o1, o2) -> {
                    int v1 = o1.getValue();
                    int v2 = o2.getValue();
                    if (v1 == v2) {
                        return Integer.compare(o1.getKey(), o2.getKey());
                    }

                    return Integer.compare(v1, v2);
                })
                .orElseThrow(() -> new NoSuchElementException("Not found winner"))
                .getKey();
    }

    static class BellmanFord {

        private final int[][] cost;

        public BellmanFord(int N, int[][] graph) {
            cost = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    cost[i][j] = INF;
                }
            }

            for (int i = 1; i <= N; i++) {
                cost[i][i] = 0;
            }

            for (int[] relation : graph) {
                int a = relation[0];
                int b = relation[1];

                cost[a][b] = 1;
                cost[b][a] = 1;
            }
        }

        public int[][] getCost() {
            return cost;
        }

        public void bellmanFord(int N) {

            for (int k = 1; k <= N; k++) {
                for (int from = 1; from <= N; from++) {
                    for (int to = 1; to <= N; to++) {
                        int path = Math.min(
                                cost[from][to],
                                cost[from][k] + cost[k][to]
                        );
                        cost[from][to] = path;
                        cost[to][from] = path;
                    }
                }
            }
        }
    }
}
