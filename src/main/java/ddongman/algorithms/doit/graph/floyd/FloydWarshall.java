package ddongman.algorithms.doit.graph.floyd;

public class FloydWarshall {

    private static final long INF = 10_000_000L;
    private long[][] cost;

    public long[][] solution(int n, int[][] graph) {
        init(n, graph);
        floydWarshall(n);
        return getCost();
    }

    private void init(int n, int[][] graph) {
        cost = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = INF;
            }
        }

        for (int i = 0; i < n; i++) {
            cost[i][i] = 0;
        }

        for (int[] edge : graph) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            int weight = edge[2];

            if (cost[from][to] > weight) {
                cost[from][to] = weight;
            }
        }
    }

    public void floydWarshall(int n) {
        for (int k = 0; k < n; k++) {
            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    cost[from][to] = Math.min(cost[from][to], cost[from][k] + cost[k][to]);
                }
            }
        }
    }

    public long[][] getCost() {
        return cost;
    }
}
