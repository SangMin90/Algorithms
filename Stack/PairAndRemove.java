import java.util.ArrayDeque;
import java.util.Deque;

public class PairAndRemove {
    public static void main(String[] args) {
        PairAndRemove sample = new PairAndRemove();
        System.out.println(sample.solution("baabaa"));
    }
    public int solution(String s)
    {
        Deque<Character> deque = new ArrayDeque<>();

        pairAndRemove(s, deque);

        if  (deque.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private void pairAndRemove(String s, Deque<Character> deque) {
        for (int i = 0; i< s.length(); i++) {
            if (!deque.isEmpty() && deque.peekLast() == s.charAt(i)) {
                deque.pollLast();
            } else {
                deque.add(s.charAt(i));
            }
        }
    }
}
