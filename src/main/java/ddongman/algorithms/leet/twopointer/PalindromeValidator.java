package ddongman.algorithms.leet.twopointer;

public class PalindromeValidator {

    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {

            char left = s.charAt(start);
            char right = s.charAt(end);
            if (!isAlphaNumeric(left)) {
                start++;
                continue;
            }

            if (!isAlphaNumeric(right)) {
                end--;
                continue;
            }

            if (isUpperCase(left)) {
                left = (char) (left + 32);
            }

            if (isUpperCase(right)) {
                right = (char) (right + 32);
            }

            if (left != right) return false;

            start++;
            end--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {

        return (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9');
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
