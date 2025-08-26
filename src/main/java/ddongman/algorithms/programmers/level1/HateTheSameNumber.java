package ddongman.algorithms.programmers.level1;

import java.util.LinkedList;
import java.util.Queue;

public class HateTheSameNumber {
    public static void main(String[] args) {
        int[] arr = {0,1};
        Queue<Integer> queue = new LinkedList<>();
        boolean consecutive = false;
        for (int i=0;i<arr.length;i++) {
            if (i == arr.length-1) {
                if (!consecutive) {
                    queue.add(arr[i]);
                }
                break;
            }
            if (arr[i] == arr[i+1]) {
                if (!consecutive) {
                    queue.add(arr[i]);
                }
                consecutive = true;
            } else {
                if (!consecutive) {
                    queue.add(arr[i]);
                }
                consecutive = false;
            }
        }
        int[] ans = new int[queue.size()];
        for (int i=0;i<ans.length;i++) {
            ans[i] = queue.poll();
        }
        for (int i=0;i<ans.length;i++) {
            System.out.println(ans[i]);
        }
    }
}
