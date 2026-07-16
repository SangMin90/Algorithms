package ddongman.algorithms.leet.stack;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifiedCanonicalPath {

    private static final String SPLITTER = "/";
    private static final String CURRENT_DIRECTORY = ".";
    private static final String PARENT_DIRECTORY = "..";

    public String simplifyPath(String path) {

        String[] paths = path.split(SPLITTER);
        Deque<String> stack = new LinkedList<>();

        for (String p : paths) {
            if (p.equals(PARENT_DIRECTORY)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!CURRENT_DIRECTORY.equals(p) && !p.isEmpty()) {
                stack.push(p);
            }
        }

        if (stack.isEmpty()) {
            return SPLITTER;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(SPLITTER).append(stack.pollLast());
        }

        return sb.toString();
    }

    public String simplifyPath2(String path) {

        int n = path.length();
        String[] paths = new String[n];

        int i = 0;
        int top = 0;
        while (i < n) {
            if (path.charAt(i) == '/') {
                while (i < n && path.charAt(i) == '/') {
                    i++;
                }
            }

            if (i == n) {
                break;
            }

            int start = i++;
            while (i < n && path.charAt(i) != '/') {
                i++;
            }

            int len = i - start;
            if (len == 2 && path.charAt(start) == '.' && path.charAt(start + 1) == '.') {
                if (top > 0) {
                    --top;
                }
            } else if (len == 1 && path.charAt(start) == '.') {
                continue;
            } else {
                paths[top++] = path.substring(start, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < top; k++) {
            sb.append(SPLITTER).append(paths[k]);
        }

        return sb.isEmpty() ? SPLITTER : sb.toString();
    }
}
