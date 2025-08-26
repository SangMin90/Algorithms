package ddongman.algorithms.doit.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MazeExploration {
    private boolean[][] visited;
    private final List<List<Queue<Point>>> link = new ArrayList<>();
    private final Queue<Point> queue = new LinkedList<>();
    private int[][] depth;
    public int solution(int n, int m, int[][] maze) {
        init(n, m, maze);

        bfs(0, 0, n, m);

        return depth[n - 1][m - 1];
    }

    private void init(int n, int m, int[][] maze) {
        visited = new boolean[n][m];

        for (int i = 0; i < maze.length; i++) {
            link.add(new ArrayList<>());
            for (int j = 0; j < maze[i].length; j++) {
                link.get(i).add(new LinkedList<>());
                if (maze[i][j] == 1) {
                    if (i >= 1 && maze[i - 1][j] == 1) {
                        link.get(i).get(j).offer(new Point(i - 1, j));
                        link.get(i - 1).get(j).offer(new Point(i, j));
                    }

                    if (j >= 1 && maze[i][j - 1] == 1) {
                        link.get(i).get(j).offer(new Point(i, j - 1));
                        link.get(i).get(j - 1).offer(new Point(i, j));
                    }
                }
            }
        }

        depth = new int[n][m];
    }

    private void bfs(int x, int y, int n, int m) {
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        queue.add(new Point(x, y));
        depth[x][y] = 1;

        while (!queue.isEmpty()) {
            Point polledPoint = queue.poll();
            Queue<Point> linkedPoints = link.get(polledPoint.getX()).get(polledPoint.getY());
            while (!linkedPoints.isEmpty()) {
                Point polledLinkedPoint = linkedPoints.poll();
                if (!visited[polledLinkedPoint.getX()][polledLinkedPoint.getY()]) {
                    visited[polledLinkedPoint.getX()][polledLinkedPoint.getY()] = true;
                    queue.add(polledLinkedPoint);
                    depth[polledLinkedPoint.getX()][polledLinkedPoint.getY()] = depth[polledPoint.getX()][polledPoint.getY()] + 1;
                }
            }
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
    }
}
