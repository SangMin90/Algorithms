package ddongman.algorithms.programmers.level1;

import java.util.Arrays;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0;i<commands.length;i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            int[] tempArray = new int[end-start+1];
            int index = 0;
            for (int j=start-1;j<end;j++) {
                tempArray[index] = array[j];
                index++;
            }
            Arrays.sort(tempArray);
            answer[i] = tempArray[k-1];
        }
        return answer;
    }
}