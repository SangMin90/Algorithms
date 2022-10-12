public class NextBiggestNumber {
    public static void main(String[] args) {
        NextBiggestNumber sample = new NextBiggestNumber();
        System.out.println(sample.solution(78));
        System.out.println(sample.solution(15));
    }
    public int solution(int n) {
        String s = Integer.toString(n, 2);
        char[] chars = s.toCharArray();

        int oneCnt = getOneCnt(chars);

        int answer = 0;

        char[] nextChars = getNextChars(chars, oneCnt);

        answer = Integer.parseInt(new String(nextChars), 2);

        return answer;
    }

    private char[] getNextChars(char[] chars, int oneCnt) {
        char[] nextChars;
        if (nextPermutation(chars)) {
            nextChars = chars;
        } else {
            nextChars = new char[chars.length + 1];
            nextChars[0] = '1';
            for (int i = 1; i < nextChars.length; i++) {
                if (i >= nextChars.length - oneCnt + 1) {
                    nextChars[i] = '1';
                } else {
                    nextChars[i] = '0';
                }
            }
        }
        return nextChars;
    }

    private int getOneCnt(char[] chars) {
        int oneCnt = 0;
        for (char c : chars) {
            if (c == '1') {
                oneCnt++;
            }
        }
        return oneCnt;
    }


    public boolean nextPermutation(char[] c) {
        int i = c.length - 1;

        while (i > 0 && c[i - 1] >= c[i]) {
            i--;
        }

        if (i <= 0) {
            return false;
        }

        int j = c.length - 1;
        while (c[i - 1] >= c[j]) {
            j--;
        }

        char temp = c[i - 1];
        c[i - 1] = c[j];
        c[j] = temp;

        j = c.length - 1;
        while (i < j) {
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
