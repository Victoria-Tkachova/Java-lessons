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

   static void one() throws  Exception{


    }

    public static void main(String[] args) throws Exception {
        one();
       //int q=56/0;
       try {
           String date = "01.02.1989";
           DateFormatter obj = new DateFormatter();
           System.out.println(obj.stringToDateFormatter(date));
           try {
               //throw  new Exception();
               int[] arr = {1, 5, 7};
               System.out.println(arr[9]);
               System.out.println(arr);
           } catch (NullPointerException e) {
               e.printStackTrace();
           } catch (ArithmeticException r) {
               System.out.println("catch 2");
              // System.exit(3);

           } finally {
               System.out.println("finally");
           }
       }catch (IllegalAccessError t){
           System.out.println("catch outer");
       }
       finally{
           System.out.println("finally 2");
       }
    }
}
