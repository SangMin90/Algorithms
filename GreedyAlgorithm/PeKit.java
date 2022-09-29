import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PeKit {

    Set<Integer> reserveSet;
    Set<Integer> lostSet;

    public int solution(int n, int[] lost, int[] reserve) {
        lostSet =  Arrays.stream(lost).boxed().collect(Collectors.toSet());

        reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());

        Set<Integer> commonSet = lostSet.stream().filter(l -> reserveSet.contains(Integer.valueOf(l))).collect(Collectors.toSet());

        lostSet.removeAll(commonSet);
        reserveSet.removeAll(commonSet);

        for (int r : reserveSet) {
            borrowPeKit(r);
        }

        return n - lostSet.size();
    }

    private void borrowPeKit(int reserve) {
        if (lostSet.contains(reserve - 1)) {
            lostSet.remove(reserve - 1);
            return;
        }
        if (lostSet.contains(reserve + 1)) {
            lostSet.remove(reserve + 1);
            return;
        }
    }
}