package ddongman.algorithms.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class FailureRate {

    public int[] solution(int N, int[] stages) {
        int[] failureCount = new int[N+2];
        for (int stage : stages) {
            failureCount[stage]++;
        }

        int[] arriveCount = new int[N + 1];
        int userCount = stages.length;
        arriveCount[0] = userCount;
        for (int i = 1; i < arriveCount.length; i++) {
            arriveCount[i] = arriveCount[i-1] - failureCount[i - 1];
        }

        Map<Integer, Double> failureRate = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            double rate = 0;
            if (Double.compare(arriveCount[i], 0) != 0) {
                rate = (double)failureCount[i] / arriveCount[i];
            }
            failureRate.put(i, rate);
        }

        LinkedHashMap<Integer, Double> collect =
                failureRate.entrySet()
                        .stream()
                        .sorted((o1, o2) -> {
                            if (o1.getValue().compareTo(o2.getValue()) == 0) {
                                return o1.getKey().compareTo(o2.getKey());
                            } else {
                                return o2.getValue().compareTo(o1.getValue());
                            }
                        })
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return collect.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
}
