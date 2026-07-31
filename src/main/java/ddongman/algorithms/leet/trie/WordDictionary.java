package ddongman.algorithms.leet.trie;

public class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {

        root.insert(word);
    }

    public boolean search(String word) {

//        return root.search(word);
        return root.search2(word.toCharArray(), 0);
    }

    public void addWord2(String word) {

        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }

        curr.isEnd = true;
    }

    public boolean search2(String word) {

        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] word, int idx, Node curr) {

        if (idx == word.length) {
            return curr.isEnd;
        }

        if (word[idx] == '.') {
            for (int i = 0; i < curr.children.length; i++) {
                if (curr.children[i] != null && match(word, idx + 1, curr.children[i])) {
                    return true;
                }
            }
        } else {

            if (curr.children[word[idx] - 'a'] == null) {
                return false;
            }

            return match(word, idx + 1, curr.children[word[idx] - 'a']);
        }

        return false;
    }

    static class Node {

        private Node[] children;
        private boolean isEnd;

        public Node() {

            this.children = new Node[26];
        }

        void insert(String word) {

            Node curr = this;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }

            curr.isEnd = true;
        }

        boolean search(String word) {

            Node curr = this;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    for (int j = 0; j < curr.children.length; j++) {
                        if (curr.children[j] != null) {
                            if (curr.children[j].search(word.substring(i + 1))) {
                                return true;
                            }
                        }
                    }

                    return false;
                } else {

                    int index = word.charAt(i) - 'a';
                    if (curr.children[index] == null) {
                        return false;
                    }

                    curr = curr.children[index];
                }
            }

            return curr.isEnd;
        }

        boolean search2(char[] word, int idx) {

            if (idx == word.length) {
                return isEnd;
            }

            if (word[idx] == '.') {
                for (int j = 0; j < this.children.length; j++) {
                    if (this.children[j] != null) {
                        if (this.children[j].search2(word, idx + 1)) {
                            return true;
                        }
                    }
                }

                return false;
            } else {
                int index = word[idx] - 'a';
                if (this.children[index] == null) {
                    return false;
                }

                return this.children[index].search2(word, idx + 1);
            }
        }
    }
}
