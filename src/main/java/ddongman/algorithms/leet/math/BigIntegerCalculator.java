package ddongman.algorithms.leet.math;

public class BigIntegerCalculator {

    public int[] plusOne(int[] digits) {

        int carry = 0;

        int i = digits.length - 1;
        int lastNum = digits[i] + 1 + carry;

        digits[i--] = lastNum % 10;
        carry = lastNum / 10;

        while (carry != 0 && i >= 0) {
            int num = digits[i] + carry;
            digits[i--] = num % 10;
            carry = num / 10;
        }

        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for (int j = 1; j < result.length; j++) {
                result[j] = digits[j - 1];
            }
            return result;
        }

        return digits;
    }

    public int[] plusOne2(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
