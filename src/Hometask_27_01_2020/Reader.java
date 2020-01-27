package Hometask_27_01_2020;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Reader {
    private String name;
    Map<Book, LocalDate[]> form = new HashMap<>();

    void addItemInForm (Book book, LocalDate take, LocalDate back) {
        form.put(book, new LocalDate[] {take, back});

    }

    Reader (String name) {
        this.name = name;
    }

    int speedOfReader (LocalDate take, LocalDate back) {
        int[] totalPage={0};
        int[] totalOurs={0};
        form.forEach((a,b) -> {
           if (b[0].isAfter(take) && b[0].isBefore(back)) {
               totalPage[0] = totalPage[0] + a.pages;
               totalOurs[0] = totalOurs[0] + Math.abs(b[0].getDayOfYear()-b[1].getDayOfYear())*24;
           }
        });
        System.out.println(totalPage[0] / totalOurs[0]);
        return totalPage[0] / totalOurs[0];
    }

}

class Book {
    String title;
    int pages;

    Book (String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}
