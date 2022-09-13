import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class YearOf2016 {
    public String solution(int a, int b) {
        LocalDate localDate = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String answer = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();

        return answer;
    }
}
