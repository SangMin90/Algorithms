package ddongman.algorithms.leet.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearcher {

    private int N;
    private int M;
    private boolean[] visited;

    private Node root = new Node();

    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        N = board.length;
        M = board[0].length;

        visited = new boolean[N * M];

        for (String word : words) {
            List<Integer> indexes = findIndexFirstChar(word, board);

            for (int index : indexes) {

                Arrays.fill(visited, false);

                if (searchWord(word, 0, index, board)) {
                    result.add(word);
                    break;
                }
            }
        }

        return result;
    }

    private boolean searchWord(String word, int wordIdx, int idx, char[][] board) {

        if (wordIdx == word.length()) return true;

        if (idx == -1) return false;

        if (visited[idx]) {
            return false;
        }

        int row = idx / M;
        int col = idx % M;
        if (board[row][col] != word.charAt(wordIdx)) {
            return false;
        }

        visited[idx] = true;

        if (searchWord(word, wordIdx + 1, row - 1 >= 0 ? (row - 1) * M + col : -1, board)) {
            return true;
        }

        if (searchWord(word, wordIdx + 1, row + 1 < N ? (row + 1) * M + col : -1, board)) {
            return true;
        }

        if (searchWord(word, wordIdx + 1, col - 1 >= 0 ? row * M + col - 1 : -1, board)) {
            return true;
        }

        if (searchWord(word, wordIdx + 1, col + 1 < M ? row * M + col + 1 : -1, board)) {
            return true;
        }

        visited[idx] = false;

        return false;
    }

    private List<Integer> findIndexFirstChar(String word, char[][] board) {

        List<Integer> indexes = new ArrayList<>();

        char first = word.charAt(0);
        for (int i = 0; i < N * M; i++) {
            int row = i / M;
            int col = i % M;
            if (board[row][col] == first) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    public List<String> findWords2(char[][] board, String[] words) {

        for (String word : words) {
            root.addWord(word);
        }

        List<String> result = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                root.searchWord(row, col, board, result);
            }
        }

        return result;
    }

    static class Node {
        Node[] children = new Node[26];
        String word;

        void addWord(String word) {

            Node curr = this;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
            }

            curr.word = word;
        }

        List<String> searchWord(int row, int col, char[][] board, List<String> words) {

            if (row < 0 || col < 0 ||
                row >= board.length || col >= board[0].length) {
                return words;
            }

            if (board[row][col] == '#') {
                return words;
            }

            int idx = board[row][col] - 'a';
            if (this.children[idx] == null) {
                return words;
            }

            Node child = this.children[idx];
            if (child.word != null && !child.word.isEmpty()) {
                words.add(child.word);
                child.word = null;
            }

            char org = board[row][col];
            board[row][col] = '#';

            child.searchWord(row - 1, col, board, words);
            child.searchWord(row + 1, col, board, words);
            child.searchWord(row, col - 1, board, words);
            child.searchWord(row, col + 1, board, words);

            board[row][col] = org;

            return words;
        }
    }
}
