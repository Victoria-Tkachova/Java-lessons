package CollectionComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunTask {
    public static void main(String[] args) {
        Student student1 = new Student("Smith", 19, 3.8f);
        Student student2 = new Student("Doe", 21, 4.8f);
        Student student3 = new Student ("Daniels", 20, 4.5f);
        Student student4 = new Student("Snow", 18, 4.9f);
        Student student5 = new Student("Lanister", 17, 2.8f);
        Student student6 = new Student("Targarian", 23, 5.0f);

        List<Student> studentList = new ArrayList<>();
        Collections.addAll(studentList, student1, student2, student3, student4, student5, student6);

        student1.chooseSortingModel(studentList);
        System.out.println(studentList);

    }
}
