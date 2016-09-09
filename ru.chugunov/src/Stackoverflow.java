import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author Andrey Chugunov on 09.09.2016.
 */
public class Stackoverflow {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2016, 9, 3); //год, мес, день
        LocalDate endDate = LocalDate.of(2016, 9, 10);

        System.out.println(countWeekend(startDate, endDate));

    }

    private static int countWeekend(LocalDate startDate, LocalDate endDate) {
        int weekdays = 0;
        if (startDate.isEqual(endDate)) {
            return weekdays;
        }

        while(startDate.isBefore(endDate)) {
            if (DayOfWeek.SATURDAY.equals(startDate.getDayOfWeek()) || DayOfWeek.SUNDAY.equals(startDate.getDayOfWeek())) {
                weekdays++;
            }
            startDate = startDate.plusDays(1);
        }

        return weekdays;
    }
}
