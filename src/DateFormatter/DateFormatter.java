package DateFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {
    LocalDate stringToDateFormatter (String date) throws ParseException {
        Date resultDate = null;
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        resultDate = formatter.parse(date);
        LocalDate result = new java.sql.Date(resultDate.getTime()).toLocalDate();
        return result;

    }

    public static void main(String[] args) throws ParseException {
        String date = "01.02.1989";
        DateFormatter obj = new DateFormatter();
        System.out.println(obj.stringToDateFormatter(date));
    }
}
