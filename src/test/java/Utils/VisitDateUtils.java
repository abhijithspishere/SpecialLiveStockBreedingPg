package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VisitDateUtils {

    private static final DateTimeFormatter INPUT_FORMAT =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final DateTimeFormatter OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String getVisitDate(String calfDOB, int daysToSubtract) {

        // Current date
        LocalDate currentDate = LocalDate.now();

        // Subtract days from current date
        LocalDate eligibleDOB =
                currentDate.minusDays(daysToSubtract);

        return eligibleDOB.format(OUTPUT_FORMAT);
    }
}