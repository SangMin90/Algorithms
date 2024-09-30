package ddongman.doit.geometric;

public class SegmentDirection {
    public int solution(int[][] points) {
        int result = 0;
        for (int x = 0; x < points.length; x++) {
            int y = (x + 1) % points.length;
            result += points[x][0] * points[y][1] - points[y][0] * points[x][1];
        }

        return Integer.compare(result, 0);
    }
}
