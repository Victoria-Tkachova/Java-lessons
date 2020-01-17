package Hometask_20_01_2020;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterStudents {

    List <Student> filterStudents (List<Student> list, List <Predicate <Student>> pred) {
        return list.stream().filter(pred.stream().reduce( x -> true, Predicate::and)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("John", 21, 198, "Literature", 2));
        list.add(new Student("Victoria", 23, 165, "Philosophy", 5));
        list.add(new Student("Valery", 17, 153, "English", 1));
        list.add(new Student("Anthony", 20, 186, "Programming", 3));
        list.add(new Student("Paul", 24, 182, "Sport", 4));
        list.add(new Student("Regina", 22, 170, "Sociology", 4));

        List<Predicate<Student>> pred = new ArrayList<>();
        pred.add(x -> x.getName().startsWith("V"));
        pred.add(x -> x.getCourse() >= 2);
        pred.add(x -> x.getSpecialty().equals("Philosophy"));
        pred.add(x -> x.getAge() %2 != 0);
        pred.add(x -> x.getHeight() < 180);

        FilterStudents obj = new FilterStudents();
        System.out.println(obj.filterStudents(list, pred));

    }
}
