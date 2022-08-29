import java.util.Arrays;

public class UncompletePlayer {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        String answer = null;

        for (int i=0;i<participant.length;i++) {
            if (i == completion.length || !participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}