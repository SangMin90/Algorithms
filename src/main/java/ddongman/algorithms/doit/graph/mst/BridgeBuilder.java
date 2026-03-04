package ddongman.algorithms.doit.graph.mst;

import java.util.*;
import java.util.function.ToIntFunction;

import static ddongman.algorithms.doit.graph.mst.BridgeBuilder.Axis.*;
import static java.util.stream.Collectors.toSet;

public class BridgeBuilder {

    private static final int MIN_DISTANCE = 2;

    private static int N;
    private static int M;
    private int[][] map;
    private boolean[][] visited;
    private final List<Island> islands = new ArrayList<>();
    private final List<Edge> graph = new ArrayList<>();

    public List<Island> getIslands() {
        return islands;
    }

    public int solution(int N, int M, int[][] map) {

        init(N, M, map);

        collectIslands(map);

        makeGraph();

        int islandCnt = islandCount();
        MST mst = new MST(graph, islandCnt);
        List<Edge> mstOfIsland = mst.kruskal(islandCnt);

        if (mstOfIsland.isEmpty()) {
            return -1;
        }

        return mstOfIsland.stream()
                .mapToInt(Edge::getWeight)
                .sum();
    }

    private void makeGraph() {
        int n = islandCount();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Island from = islands.get(i);
                Island to = islands.get(j);

                graph.addAll(findBridgeEndPointBetween(from, to));
            }
        }
    }

    private Set<Edge> findBridgeEndPointBetween(Island i1, Island i2) {

        Set<Edge> edges = new HashSet<>();

        Set<Integer> intersectionOfX = findSameAxisValueBetween(i1, i2, X);
        Set<Integer> intersectionOfY = findSameAxisValueBetween(i1, i2, Y);

        for (Integer x : intersectionOfX) {
            findBridgeEndPointOnAxisBetween(i1, i2, X, x)
                    .ifPresent(edges::add);
        }

        for (Integer y : intersectionOfY) {
            findBridgeEndPointOnAxisBetween(i1, i2, Y, y)
                    .ifPresent(edges::add);
        }

        return edges;
    }

    private Optional<Edge> findBridgeEndPointOnAxisBetween(Island i1, Island i2, Axis axis, Integer intersection) {

        List<Point> pointsOfI1 = extractAndSort(i1, axis, intersection);
        List<Point> pointsOfI2 = extractAndSort(i2, axis, intersection);

        // 같은 직선상에 좌표가 없는 경우
        if (pointsOfI1.isEmpty() || pointsOfI2.isEmpty()) {
            return Optional.empty();
        }

        // 두 섬 사이에 또다른 섬이 존재하는 경우
        if (existsAnotherIslandOnSameAxisBetween(pointsOfI1, pointsOfI2, axis, intersection)) {

            return Optional.empty();
        }

        int weight = calculateWeight(pointsOfI1, pointsOfI2, axis);

        if (weight < MIN_DISTANCE) {
            return Optional.empty();
        }

        return Optional.of(new Edge(i1.getNumber(), i2.getNumber(), weight));
    }


    private int calculateWeight(List<Point> i1, List<Point> i2, Axis axis) {

        int candidate1 = Math.abs(axis.getOtherValue(i1.getFirst()) - axis.getOtherValue(i2.getLast())) - 1;
        int candidate2 = Math.abs(axis.getOtherValue(i1.getLast()) - axis.getOtherValue(i2.getFirst())) - 1;
        return Math.min(candidate1, candidate2);
    }

    private boolean existsAnotherIslandOnSameAxisBetween(
            List<Point> i1, List<Point> i2, Axis axis, Integer axisValue
    ) {

        int compare1 = axis.getOtherValue(i1.getFirst());
        int compare2 = axis.getOtherValue(i2.getFirst());

        Point start = compare1 > compare2 ? i2.getLast() : i1.getLast();
        Point end = compare1 > compare2 ? i1.getFirst() : i2.getFirst();

        for (int i = axis.getOtherValue(start) + 1; i < axis.getOtherValue(end); i++) {
            if (axis.getMapValue(map, axisValue, i) == 1) {
                return true;
            }
        }

        return false;
    }

    private List<Point> extractAndSort(Island island, Axis axis, Integer axisValue) {
        return island.getPoints()
                .stream()
                .filter(point -> axisValue.compareTo(axis.getValue(point)) == 0)
                .sorted(Comparator.comparingInt(axis::getOtherValue))
                .toList();
    }

    private Set<Integer> findSameAxisValueBetween(
            Island i1, Island i2, Axis axis
    ) {

        Set<Integer> valuesOfI1 = i1.getPoints()
                .stream()
                .map(axis::getValue)
                .collect(toSet());
        Set<Integer> valuesOfI2 = i2.getPoints()
                .stream()
                .map(axis::getValue)
                .collect(toSet());

        valuesOfI1.retainAll(valuesOfI2);

        return valuesOfI1;
    }


    private void collectIslands(int[][] map) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    islands.add(exploreIslandBy(new Point(x, y)));
                }
            }
        }
    }

    private void init(int N, int M, int[][] map) {
        this.N = N;
        this.M = M;

        this.map = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, this.map[i], 0, M);
        }

        visited = new boolean[N][M];
    }

    private Island exploreIslandBy(Point point) {

        Island island = new Island(islandCount());

        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        island.addPoint(new Point(point.getX(), point.getY()));

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.getX();
            int y = p.getY();
            visited[x][y] = true;

            if (!isOutOfRange(x - 1, y) && map[x - 1][y] == 1 && !visited[x - 1][y]) {

                queue.offer(new Point(x - 1, y));
                visited[x - 1][y] = true;
            }

            if (!isOutOfRange(x + 1, y) && map[x + 1][y] == 1 && !visited[x + 1][y]) {

                queue.offer(new Point(x + 1, y));
                visited[x + 1][y] = true;
            }

            if (!isOutOfRange(x, y - 1) && map[x][y - 1] == 1 && !visited[x][y - 1]) {

                queue.offer(new Point(x, y - 1));
                visited[x][y - 1] = true;
            }

            if (!isOutOfRange(x, y + 1) && map[x][y + 1] == 1 && !visited[x][y + 1]) {

                queue.offer(new Point(x, y + 1));
                visited[x][y + 1] = true;
            }

            island.addPoint(p);
        }

        return island;
    }

    private boolean isOutOfRange(int x, int y) {
        return x >= N || y >= M || x < 0 || y < 0;
    }

    private int islandCount() {
        return getIslands().size();
    }

    static class Island {

        private final int number;

        private final Set<Point> points = new HashSet<>();

        public Island(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public boolean addPoint(Point point) {
            return points.add(point);
        }

        public Set<Point> getPoints() {
            return points;
        }
    }

    static class Point {
        private final int x;

        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof Point point)) return false;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    enum Axis {
        X(Point::getX, Point::getY, (map, axisValue, otherValue) -> map[axisValue][otherValue]),
        Y(Point::getY, Point::getX, (map, axisValue, otherValue) -> map[otherValue][axisValue]);

        private final ToIntFunction<Point> AxisValueExtractor;
        private final ToIntFunction<Point> otherAxisValueExtractor;
        private final MapAccessor mapValueExtractor;

        Axis(ToIntFunction<Point> AxisValueExtractor,
             ToIntFunction<Point> otherAxisValueExtractor,
             MapAccessor mapValueExtractor) {
            this.AxisValueExtractor = AxisValueExtractor;
            this.otherAxisValueExtractor = otherAxisValueExtractor;
            this.mapValueExtractor = mapValueExtractor;
        }

        int getValue(Point point) {
            return AxisValueExtractor.applyAsInt(point);
        }

        int getOtherValue(Point point) {
            return otherAxisValueExtractor.applyAsInt(point);
        }

        int getMapValue(int[][] map, int x, int y) {
            return mapValueExtractor.get(map, x, y);
        }

        @FunctionalInterface
        interface MapAccessor {
            int get(int[][] map, int x, int y);
        }
    }


    static class Edge implements Comparable<Edge> {
        private final int from;
        private final int to;
        private final int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(getWeight(), o.getWeight());
        }

        @Override
        public boolean equals(Object object) {

            if (this == object) return true;
            if (!(object instanceof Edge edge)) return false;
            return from == edge.from && to == edge.to && weight == edge.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to, weight);
        }
    }

    static class MST {

        private final List<Edge> graph = new ArrayList<>();
        private final UnionFind unionFind;

        public MST(List<Edge> graph, int N) {
            this.graph.addAll(graph);
            this.unionFind = new UnionFind(N);
        }

        public List<Edge> kruskal(int N) {

            List<Edge> mst = new ArrayList<>();

            Collections.sort(graph);

            for (Edge edge : graph) {
                int from = edge.getFrom();
                int to = edge.getTo();
                int weight = edge.getWeight();

                if (unionFind.isSameUnion(from, to)) {
                    continue;
                }

                unionFind.union(from, to);
                mst.add(new Edge(from, to, weight));

                if (mst.size() == N - 1) {
                    break;
                }
            }

            return mst.size() == N - 1 ? mst : List.of();
        }
    }

    static class UnionFind {

        private final int[] root;

        public UnionFind(int N) {
            this.root = new int[N];

            for (int i = 0; i < N; i++) {
                root[i] = i;
            }
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }

            root[rootB] = rootA;
        }

        public int find(int a) {
            if (root[a] != a) {
                root[a] = find(root[a]);
            }

            return root[a];
        }

        public boolean isSameUnion(int a, int b) {
            return find(a) == find(b);
        }
    }
}
