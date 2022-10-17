import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReleaseNote {
    public static void main(String[] args) {
        ReleaseNote sample = new ReleaseNote();
        int[] solution = sample.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        for (int i : solution) {
            System.out.println(i);
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {

        LinkedList<Integer> elapsedDays = getElapsedDays(progresses, speeds);

        List<Integer> releaseNote = getReleaseNote(elapsedDays);

        return releaseNote.stream().mapToInt(Integer::intValue).toArray();
    }

    List<Integer> getReleaseNote(LinkedList<Integer> elapsedDays) {
        List<Integer> releaseNote = new ArrayList<>();

        while (!elapsedDays.isEmpty()) {
            int releaseCount = 1;

            int front = elapsedDays.poll();
            while (!elapsedDays.isEmpty() && front >= elapsedDays.peekFirst()) {
                elapsedDays.poll();
                releaseCount++;
            }

            releaseNote.add(releaseCount);
        }
        return releaseNote;
    }

    LinkedList<Integer> getElapsedDays(int[] progresses, int[] speeds) {
        LinkedList<Integer> elapsedDays = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int elapsedDay = (100 - progresses[i]) / speeds[i];
            elapsedDays.add((100 - progresses[i]) % speeds[i] == 0 ? elapsedDay : elapsedDay + 1);
        }
        return elapsedDays;
    }
}
