package ddongman.algorithms.leet.bit;

public class BinaryCalculator {

    public String addBinary(String a, String b) {

        int lenDiff = Math.abs(a.length() - b.length());
        if (a.length() < b.length()) {
            String temp = b;
            b = a;
            a = temp;
        }

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            int digit = (a.charAt(i) - '0') +
                (i - lenDiff < 0 ? 0 : b.charAt(i - lenDiff) - '0') +
                carry;

            carry = (digit / 2 == 1) ? 1 : 0;

            sb.append(digit % 2);
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public String addBinary2(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;


        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            carry = sum / 2;
            sb.append(sum % 2);
        }

        return sb.reverse().toString();
    }
}
