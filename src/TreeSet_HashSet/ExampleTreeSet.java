package TreeSet_HashSet;

import java.util.*;

import sun.reflect.generics.tree.Tree;

public class ExampleTreeSet {
    public static void main(String[] args) {
        Student student1 = new Student ("Smith", "test@test.email");
        Student student2 = new Student ("Daniels", "daniels@email.com");
        Student student3 = new Student ("Hilfiger", "test@test.email");
        Student student4 = new Student ("Smith", "smith@unique.email");

        Set<Student> studentTreeSet = new TreeSet<>(new Student.StudentEmailComparator());
        Collections.addAll(studentTreeSet, student1, student2, student3, student4);

        for (Student temp:studentTreeSet) {
            System.out.println(temp.getLastName() + " " + temp.getEmail());
        }

        Set<Student> studentHashSet = new HashSet<>();
        Collections.addAll(studentHashSet, student1, student2, student3, student4);


        for (Student temp1:studentHashSet) {
            System.out.println("список по хэш-сету: " + temp1.getLastName() + " " + temp1.getEmail());
        }

    }
}
