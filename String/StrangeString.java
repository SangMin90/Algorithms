public class StrangeString {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                if (idx % 2 == 0) {
                    chars[i] = String.valueOf(chars[i]).toUpperCase().charAt(0);
                } else {
                    chars[i] = String.valueOf(chars[i]).toLowerCase().charAt(0);
                }
                idx++;
            } else {
                idx = 0;
            }
        }
        String answer = new String(chars);
        return answer;
    }
}
