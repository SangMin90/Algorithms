package ddongman.algorithms.doit.tree.trie;

public class StringSet {

    private Node ROOT = new Node();

    public int solution(int N, int M, String[] words) {
        for (int i = 0; i < N; i++) {
            String s = words[i];

            ROOT.addWord(s);
        }

        int count = 0;
        for (int i = N; i < N + M; i++) {
            if (ROOT.find(words[i])) {
                count++;
            }
        }

        return count;
    }

    static class Node {

        private final Node[] children;
        private boolean isEnd;

        public Node() {
            children = new Node[26];
        }

        public void addWord(String s) {

            Node parent = this;
            for (char c : s.toCharArray()) {

                int index = c - 'a';
                if (parent.children[index] == null) {
                    parent.children[index] = new Node();
                }
                parent = parent.children[index];
            }

            parent.completeWord();
        }

        public void completeWord() {
            this.isEnd = true;
        }

        public boolean find(String s) {

            Node parent = this;
            for (char c : s.toCharArray()) {

                int index = c - 'a';
                parent = parent.children[index];
                if (parent == null) {
                    return false;
                }
            }

            return parent.isEnd;
        }
    }

}
