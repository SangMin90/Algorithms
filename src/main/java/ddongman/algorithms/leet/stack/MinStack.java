package ddongman.algorithms.leet.stack;

public class MinStack {

    private Integer[] stack;
    private int tail;
    private Integer[] min;

    private Node[] stack2;

    private Node2 head;

    public MinStack() {
        stack = new Integer[30000];
        min = new Integer[30000];

        stack2 = new Node[30000];

        tail = -1;
    }

    public void push(int value) {
        stack[++tail] = value;

        if (tail == 0) {
            min[tail] = value;
        } else {
            min[tail] = Math.min(min[tail - 1], value);
        }
    }

    public void pop() {
        if (tail < 0) {
            throw new NullPointerException("스택 내 요소가 없습니다.");
        }

        stack[tail] = null;
        min[tail] = null;

        tail--;
    }

    public int top() {
        if (tail == -1) {
            throw new NullPointerException("스택 내 요소가 없습니다.");
        }

        return stack[tail];
    }

    public int getMin() {
        if (tail == -1) {
            throw new NullPointerException("스택 내 요소가 없습니다.");
        }

        return min[tail];
    }

    public void push2(int value) {

        if (tail < 0) {
            stack2[++tail] = new Node(value, value);
        } else {
            stack2[++tail] = new Node(
                value, Math.min(stack2[tail - 1].min, value)
            );
        }
    }

    public void pop2() {
        if (tail < 0) {
            throw new NullPointerException("스택 내 요소가 없습니다.");
        }

        stack[tail--] = null;
    }

    public int top2() {
        if (tail == -1) {
            throw new NullPointerException("스택 내 요소가 없습니다.");
        }

        return stack2[tail].value;
    }

    public int getMin2() {
        if (tail == -1) {
            throw new NullPointerException("스택 내 요소가 없습니다.");
        }

        return stack2[tail].min;
    }

    record Node(int value, int min) { }

    public void push3(int value) {

        if (head == null) {
            head = new Node2(value, value);
        } else {
            head = new Node2(value, Math.min(head.min, value), head);
        }
    }

    public void pop3() {
        if (head == null) {
            throw new NullPointerException("스택 내 요소가 없습니다.");
        }

        head = head.next;
    }

    public int top3() {
        if (head == null) {
            throw new NullPointerException("스택 내 요소가 없습니다.");
        }

        return head.value;
    }

    public int getMin3() {
        if (head == null) {
            throw new NullPointerException("스택 내 요소가 없습니다.");
        }

        return head.min;
    }

    static class Node2 {
        private int value;
        private int min;
        private Node2 next;

        public Node2(int value, int min) {
            this.value = value;
            this.min = min;
        }

        public Node2(int value, int min, Node2 next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }
}
