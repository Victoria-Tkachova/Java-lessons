package Hometask_27_01_2020;

import sun.swing.BakedArrayList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library1 {
    ArrayList<Reader> library = new ArrayList<>();

    void addReader (Reader reader) {
        library.add(reader);
    }

    public static void main(String[] args) {
        Book book1 = new Book ("Aladdin", 65);
        Book book2 = new Book ("Cinderella", 105);
        Book book3 = new Book ("Mermaid", 98);
        Book book4 = new Book ("Beauty and beast", 78);

        Reader reader1 = new Reader ("Smith");
        Reader reader2 = new Reader ("Doe");
        Reader reader3 = new Reader ("Tailor");
        Reader reader4 = new Reader ("Gordon");

        Library1 dandelion = new Library1();
        dandelion.addReader(reader1);
        dandelion.addReader(reader2);
        dandelion.addReader(reader3);
        dandelion.addReader(reader4);

        LocalDate take = LocalDate.of(2019,1,1);
        LocalDate back = LocalDate.of(2019,1,31);

       reader1.addItemInForm(book1, LocalDate.of(2019, 1, 20), LocalDate.of(2019,1,23));
       reader1.addItemInForm(book2, LocalDate.of(2019, 2, 10), LocalDate.of(2019,2,25));
       reader2.addItemInForm(book1, LocalDate.of(2019, 1, 21), LocalDate.of(2019,1,22));
       reader2.addItemInForm(book2, LocalDate.of(2019, 2, 23), LocalDate.of(2019,2,25));
       reader3.addItemInForm(book2, LocalDate.of(2019, 1, 15), LocalDate.of(2019,1,25));
       reader1.addItemInForm(book3, LocalDate.of(2019, 2, 23), LocalDate.of(2019,2,27));

        ArrayList<Book> total = new ArrayList(reader1.form.keySet());
        total.addAll(reader2.form.keySet());
        total.addAll(reader3.form.keySet());
        total.addAll(reader4.form.keySet());

        total.stream().distinct().map(x -> x.title).forEach(v -> calcCountBook(v,total));
        dandelion.library.stream().forEach(v -> {
            System.out.println(v);
            System.out.println(v.speedOfReader(take, back));
        });
    }

    private static void calcCountBook(String v, ArrayList<Book> total) {
        int counter = 0;
        for (Book book:total){
        if (book.title.equals(v)) {
            counter++;
        } }
        System.out.println(v + "-" + counter);
    }
}
