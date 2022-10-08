public class RepeatingBinaryConverter {
    public int[] solution(String s) {

        int convertedCnt = 0;
        int removedZeroCnt = 0;

        while (!s.equals("1")) {
            int beforeLength = s.length();
            int afterLength =  s.replaceAll("0", "").length();

            removedZeroCnt += beforeLength - afterLength;

            s = Integer.toBinaryString(afterLength);

            convertedCnt++;
        }

        return new int[]{convertedCnt, removedZeroCnt};
    }
}
