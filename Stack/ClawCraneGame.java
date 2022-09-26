import java.util.ArrayDeque;
import java.util.Deque;

public class ClawCraneGame {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        ClawCraneGame game = new ClawCraneGame();
        System.out.println(game.solution(board, moves));
    }
    public int solution(int[][] board, int[] moves) {

        Deque<Integer> basket = new ArrayDeque<>();

        Deque<Integer>[] boardDeque = new Deque[board[0].length];
        for (int i = 0; i < boardDeque.length; i++) {
            boardDeque[i] = new ArrayDeque<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    boardDeque[j].add(board[i][j]);
                }
            }
        }

        int answer = 0;

        for (int move : moves) {
            Integer doll = boardDeque[move - 1].pollLast();
            Integer lastDoll = basket.peekLast();
            if (lastDoll != null && lastDoll.equals(doll)) {
                basket.pollLast();
                answer += 2;
            } else if (doll != null) {
                basket.add(doll);
            }
        }

        return answer;
    }
}