public class AverageOfIntArray {
    public double solution(int[] arr) {
        int sum = 0;
        for (int idx=0;idx<arr.length;idx++) {
            sum += arr[idx];
        }
        double answer = (double) sum / arr.length;
        return answer;
    }
}
