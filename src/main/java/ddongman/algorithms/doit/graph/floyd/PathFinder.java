package ddongman.algorithms.doit.graph.floyd;

public class PathFinder {

    private final static int INF = 100;

    public long[][] solution(int N, int[][] graph) {
        FloydWarshall floydWarshall = new FloydWarshall(N, graph);
        floydWarshall.floydWarshall(N);
        long[][] cost = floydWarshall.getCost();

        boolean[] selfReachable = findSelfReachable(cost);

        return buildReachabilityMatrix(cost, selfReachable);
    }

    private boolean[] findSelfReachable(long[][] cost) {
        int n = cost.length;
        boolean[] selfReachable = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (cost[i][k] != INF && cost[k][i] != INF && cost[i][k] + cost[k][i] > 0) {
                    selfReachable[i] = true;
                    break;
                }
            }
        }

        return selfReachable;
    }

    private long[][] buildReachabilityMatrix(long[][] cost, boolean[] selfReachable) {
        int n = cost.length;
        long[][] path = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = cost[i][j] != INF && cost[i][j] > 0 ? 1 : 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (selfReachable[i]) {
                path[i][i] = 1;
            }
        }

        return path;
    }

    static class FloydWarshall {
        private final long[][] cost;

        public FloydWarshall(int N, int[][] graph) {
            cost = new long[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cost[i][j] = INF;
                }
            }

            for (int i = 0; i < N; i++) {
                cost[i][i] = 0;
            }

            for (int from = 0; from < N; from++) {
                for (int to = 0; to < N; to++) {
                    int weight = graph[from][to];
                    if (weight != 0) {
                        cost[from][to] = weight;
                    }
                }
            }
        }

        public void floydWarshall(int N) {
            for (int k = 0; k < N; k++) {
                for (int from = 0; from < N; from++) {
                    for (int to = 0; to < N; to++) {
                        cost[from][to] = Math.min(cost[from][to], cost[from][k] + cost[k][to]);
                    }
                }
            }
        }

        public long[][] getCost() {
            return cost;
        }
    }
}
