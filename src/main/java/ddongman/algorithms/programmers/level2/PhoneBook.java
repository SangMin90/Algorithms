package ddongman.algorithms.programmers.level2;

import java.util.Arrays;

public class PhoneBook {
    public static void main(String[] args) {
        PhoneBook sample = new PhoneBook();
        System.out.println(sample.solution(new String[]{"119", "97674223", "1195524421"}));
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        return existPrefixPhoneNumber(phone_book);
    }

    private boolean existPrefixPhoneNumber(String[] phone_book) {
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i].length() < phone_book[i + 1].length() && phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
