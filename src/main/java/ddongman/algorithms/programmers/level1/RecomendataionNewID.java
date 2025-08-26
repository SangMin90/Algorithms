package ddongman.algorithms.programmers.level1;

public class RecomendataionNewID {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase().replaceAll("[[^a-z]&&[^0-9]&&[^-._]]","").replaceAll("\\.+",".");

        if (answer.startsWith(".")) {
            answer = answer.replaceFirst("\\.","");
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }
        if (answer.isEmpty()) {
            answer += "a";
        }
        if (answer.length() >= 16) {
            answer = answer.substring(0,15);
            if (answer.endsWith(".")) {
                answer = answer.substring(0,answer.length()-1);
            }
        }
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.substring(answer.length()-1);
            }
        }
        return answer;
    }
}
