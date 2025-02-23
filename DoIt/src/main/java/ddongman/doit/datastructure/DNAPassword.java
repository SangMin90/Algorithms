package ddongman.doit.datastructure;

import java.util.*;
import java.util.stream.IntStream;

import static ddongman.doit.datastructure.DNAPassword.DNA.*;

public class DNAPassword {

    public int solution(int s, int p, String dna, int[] minCount) {
        Map<DNA, Integer> passwordPolicy = Map.of(
                A, minCount[0],
                C, minCount[1],
                G, minCount[2],
                T, minCount[3]
        );

        return countValidPassword(s, p, dna, passwordPolicy);
    }

    private int countValidPassword(int s, int p, String dnaStr, Map<DNA, Integer> passwordPolicy) {
        Queue<DNA> queue = new LinkedList<>();
        Map<DNA, Integer> dnaCount = new HashMap<>(Map.of(
                A, 0,
                C, 0,
                G, 0,
                T, 0
        ));

        return IntStream.range(0, s)
                .map(i -> {
                    if (queue.size() == p) {
                        DNA polled = queue.poll();
                        dnaCount.put(polled, dnaCount.get(polled) - 1);
                    }

                    DNA added = DNA.valueOf(String.valueOf(dnaStr.charAt(i)));
                    queue.add(added);
                    dnaCount.put(added, dnaCount.get(added) + 1);

                    return isValid(passwordPolicy, dnaCount) ? 1 : 0;
                }).sum();
    }

    private boolean isValid(Map<DNA, Integer> expected, Map<DNA, Integer> real) {
        return expected.equals(real);
    }

    enum DNA {
        A, C, G, T
    }
}
