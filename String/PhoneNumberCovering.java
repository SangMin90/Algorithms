public class PhoneNumberCovering {
    public String solution(String phone_number) {
        String afterNumber = phone_number.substring(phone_number.length()-4);
        String beforeNumber = phone_number.substring(0,phone_number.length()-4).replaceAll("\\w","*");
        String answer = beforeNumber + afterNumber;
        return answer;
    }
}