package ddongman.algorithms.leet.trie;

public class Trie {

    private Trie[] children;
    private boolean isEnd;

    private Node root;

    public Trie() {
//        children = new Trie[26];
        root = new Node();
    }

    public void insert(String word) {

        if (isEmpty(word)) {
            return;
        }

        Trie parent = this;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (parent.children[index] == null) {
                parent.children[index] = new Trie();
            }

            parent = parent.children[index];
        }

        parent.isEnd = true;
    }

    public boolean search(String word) {

        if (isEmpty(word)) {
            return false;
        }

        Trie parent = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (parent.children[index] == null) {
                return false;
            }

            parent = parent.children[index];
        }

        return parent.isEnd;
    }

    public boolean startsWith(String prefix) {

        if (isEmpty(prefix)) {
            return false;
        }

        Trie parent = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (parent.children[index] == null) {
                return false;
            }

            parent = parent.children[index];
        }

        return true;
    }

    private boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public void insert2(String word) {
        if (isEmpty(word)) {
            return;
        }
//        root.insert(word);
        root.insert2(word, 0);
    }

    public boolean search2(String word) {
        if (isEmpty(word)) {
            return false;
        }
//        return root.search(word);
        return root.search2(word, 0);
    }

    public boolean startsWith2(String prefix) {
        if (isEmpty(prefix)) {
            return false;
        }
//        return root.startsWith(prefix);
        return root.startsWith2(prefix, 0);
    }

    static class Node {

        private Node[] children;
        private boolean isEnd;

        public Node() {
            children = new Node[26];
        }

        private void insert(String word) {

            Node parent = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (parent.children[index] == null) {
                    parent.children[index] = new Node();
                }

                parent = parent.children[index];
            }

            parent.isEnd = true;
        }

        private void insert2(String word, int len) {

            if (len >= word.length()) {
                return;
            }

            int index = word.charAt(len) - 'a';
            if (children[index] == null) {
                children[index] = new Node();
            }

            if (len == word.length() - 1) {
                children[index].isEnd = true;
            }

            children[index].insert2(word, len + 1);
        }

        private boolean search(String word) {

            Node parent = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (parent.children[index] == null) {
                    return false;
                }
                parent = parent.children[index];
            }

            return parent.isEnd;
        }

        private boolean search2(String word, int len) {

            if (len >= word.length()) {
                return false;
            }

            int index = word.charAt(len) - 'a';
            if (children[index] == null) {
                return false;
            }

            if (len == word.length() - 1) {
                return children[index].isEnd;
            }

            return children[index].search2(word, len + 1);
        }

        private boolean startsWith(String prefix) {

            Node parent = this;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (parent.children[index] == null) {
                    return false;
                }
                parent = parent.children[index];
            }

            return true;
        }

        private boolean startsWith2(String prefix, int len) {

            if (len >= prefix.length()) {
                return false;
            }

            int index = prefix.charAt(len) - 'a';
            if (children[index] == null) {
                return false;
            }

            if (len == prefix.length() - 1) {
                return true;
            }

            return children[index].startsWith2(prefix, len + 1);
        }
    }
}
