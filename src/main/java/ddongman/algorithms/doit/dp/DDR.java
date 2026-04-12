package ddongman.algorithms.doit.dp;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DDR {

    private static final int INF = 400_000;
    private final int N;
    private final int[][][] dp;

    public DDR(int N) {
        this.N = N;
        dp = new int[N + 1][5][5];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        dp[0][0][0] = 0;
    }

    public int play(int[] directions) {

        for (int arrow = 1; arrow <= N; arrow++) {
            Direction to = Direction.of(directions[arrow - 1]);

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {

                    int currentPower = dp[arrow - 1][l][r];
                    if (currentPower == INF) {
                        continue;
                    }

                    Player player = new Player(Direction.of(l), Direction.of(r), currentPower);

                    Player movedLeftPlayer = player.moveLeftNext(to);
                    Player movedRightPlayer = player.moveRightNext(to);

                    if (!movedLeftPlayer.isDoubleStep()) {
                        dp[arrow][to.value][r] = Math.min(
                                dp[arrow][to.value][r],
                                movedLeftPlayer.getPower()
                        );
                    }

                    if (!movedRightPlayer.isDoubleStep()) {
                        dp[arrow][l][to.value] = Math.min(
                                dp[arrow][to.value][l],
                                movedRightPlayer.getPower()
                        );
                    }
                }
            }
        }

        return Arrays.stream(dp[N])
                .flatMapToInt(Arrays::stream)
                .min()
                .orElseThrow(() -> new RuntimeException("최소 힘의 합을 찾을 수 없습니다."));
    }

    static class Player {

        private final Direction left;
        private final Direction right;
        private final int currentPower;

        public Player(Direction left, Direction right, int currentPower) {
            this.left = left;
            this.right = right;
            this.currentPower = currentPower;
        }

        public Player moveLeftNext(Direction nextArrow) {
            return new Player(nextArrow, right, currentPower + movingPower(left, nextArrow));
        }

        public Player moveRightNext(Direction nextArrow) {
            return new Player(left, nextArrow, currentPower + movingPower(right, nextArrow));
        }

        public boolean isDoubleStep() {
            return left.value == right.value;
        }

        public int getPower() {
            return currentPower;
        }

        private int movingPower(Direction from, Direction to) {

            if (to.isSame(Direction.CENTER)) {
                throw new RuntimeException("센터 방향으로 이동할 수 없습니다.");
            }

            if (from.isOpposite(to)) {
                return 4;
            }

            if (from.isCenter()) {
                return 2;
            }

            if (from.isSame(to)) {
                return 1;
            }

            return 3;
        }
    }

    enum Direction {
        CENTER(0), UP(1), LEFT(2), DOWN(3), RIGHT(4);

        private final int value;
        private static final Direction[] VALUES = values();

        Direction(int value) {
            this.value = value;
        }

        public static Direction of(int direction) {
            return VALUES[direction];
        }

        private boolean isOpposite(Direction other) {
            if (CENTER.equals(this) || CENTER.equals(other)) {
                return false;
            }

            return Math.abs(this.value - other.value) == 2;
        }

        private boolean isCenter() {
            return CENTER.equals(this);
        }

        private boolean isSame(Direction other) {
            return this.value == other.value;
        }

        public int power(Direction to) {

            if (this.isOpposite(to)) {
                return 4;
            }

            if (this.isCenter()) {
                return 2;
            }

            if (isSame(to)) {
                return 1;
            }

            return 3;
        }
    }
}
