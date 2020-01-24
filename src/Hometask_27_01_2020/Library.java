package Hometask_27_01_2020;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library {
    public static enum Books {
    LITTLE_PRINCE, CINDERELLA, SNOW_WHITE, LITTLE_RED_RIDING_HOOD, MERMAID, ALADDIN, SLEEPING_BEAUTY
    }

    private String readerName;
    private Map <Books, List <LocalDate>> form = new HashMap<>();

    Library (String readerName) {
        this.readerName = readerName;
    }

    @Override
    public String toString() {
        return "Library{" +
                "readerName='" + readerName + '\'' +
                ", form=" + form +
                '}';
    }

    Books populateBook (List<Library> library, LocalDate peroidStart, int days) {
        Books result = null;
        List<LocalDate> temp = Stream.iterate(peroidStart, date-> date.plusDays(days)).limit(days).collect(Collectors.toList());
//        library.stream().map(x -> x.form).flatMap(x -> x.values().stream().filter(temp::equals).collect(Collectors.joining())).);

        return result;
    }

    public static void main(String[] args) {
        ArrayList <Library> library = new ArrayList<>();
        library.add(new Library("Smith"));
        library.add(new Library("Doe"));
        library.add(new Library("Paul"));
        library.add(new Library("Willis"));

        Map <Books, List <LocalDate>> formSmith = library.get(0).form;
        Map <Books, List <LocalDate>> formDoe = library.get(1).form;
        Map <Books, List <LocalDate>> formPaul = library.get(2).form;
        Map <Books, List <LocalDate>> formWillis = library.get(3).form;

    }
}
