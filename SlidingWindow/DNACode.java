import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DNACode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        sc.nextLine();

        String str = sc.nextLine();

        int[] dna_limit_list = new int[4];

        for (int i = 0; i < 4; i++) {
            dna_limit_list[i] = sc.nextInt();
        }

        DNACode sample = new DNACode();
        System.out.println(sample.solution(N, K, str, dna_limit_list));
    }

    char[] dna_chars;

    public int solution(int N, int K, String str, int[] A) {
        Map<Character, Integer> dna_limit = new HashMap<>();
        dna_limit.put('A', A[0]);
        dna_limit.put('C', A[1]);
        dna_limit.put('G', A[2]);
        dna_limit.put('T', A[3]);

        dna_chars = str.toCharArray();

        Map<Character, Integer> dna_map = new HashMap<>();
        dna_map.put('A', 0);
        dna_map.put('C', 0);
        dna_map.put('G', 0);
        dna_map.put('T', 0);

        for (int i = 0; i < K; i++) {
            add(dna_map, i);
        }

        int answer = 0;

        if (isDnaCode(dna_limit, dna_map)) {
            answer++;
        }

        for (int i = K; i < N; i++) {
            add(dna_map, i);
            subtract(i, K, dna_map);

            if (isDnaCode(dna_limit, dna_map)) {
                answer++;
            }
        }

        return answer;
    }

    void subtract(int i, int K, Map<Character, Integer> dna_map) {
        if (dna_map.containsKey(dna_chars[i - K])) {
            dna_map.put(dna_chars[i - K], dna_map.get(dna_chars[i - K]) - 1);
        }
    }

    void add(Map<Character, Integer> dna_map, int i) {
        if (dna_map.containsKey(dna_chars[i])) {
            dna_map.put(dna_chars[i], dna_map.get(dna_chars[i]) + 1);
        }
    }

    boolean isDnaCode(Map<Character, Integer> dna_limit, Map<Character, Integer> dna_map) {
        for (Character key : dna_limit.keySet()) {
            if (dna_limit.get(key).compareTo(dna_map.get(key)) > 0) {
                return false;
            }
        }
        return true;
    }
}
