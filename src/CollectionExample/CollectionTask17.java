package CollectionExample;

import sun.reflect.generics.tree.Tree;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

public class CollectionTask17 {
    public static class Student {
        private String surname;
        private String email;
        private LocalDate dateOfBirth;

        Student(String surname, String email, LocalDate dateOfBirth) {
            this.surname = surname;
            this.email = email;
            this.dateOfBirth = dateOfBirth;
        }

        String getSurname() {
            return surname;
        }

        String getEmail() {
            return email;
        }

        LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public static class StudentSurnameComparator implements Comparator<Student> {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        }

        public static class StudentEmailComparator implements Comparator<Student> {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getEmail().compareTo(o2.getEmail());
            }
        }

        public static class DateOfBirthComparator implements Comparator<Student> {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
            }
        }
    }

    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>(new Student.StudentSurnameComparator());
        Student student1 = new Student("Иванов", "someemail@something", LocalDate.of(1989, 2, 21));
        Student student2 = new Student("Петров", "some@something.com", LocalDate.of(1995, 12, 5));
        Student student3 = new Student("Сидоров", "someemail@something", LocalDate.of(1998, 4, 21));
        Student student4 = new Student("Иванов", "newemailaddress12@something.com", LocalDate.of(1991, 1, 2));
        Student student5 = new Student("Трянов", "someemail@something", LocalDate.of(1993, 9, 8));
        Student student6 = new Student("Козлов", "graceful2193@gmail.com", LocalDate.of(1992, 5, 25));
        Student student7 = new Student("Хмельницкий", "ourtestimgzone@gmail.com", LocalDate.of(1989, 2, 21));
        Student student8 = new Student("Торопенко", "victor@gmail.com", LocalDate.of(1994, 2, 14));

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);

        TreeSet<Student> students1 = new TreeSet<>(new Student.StudentEmailComparator());
        students1.addAll(students);
        students.clear();
        students.addAll(students1);

        TreeSet <Student> students2 = new TreeSet <> (new Student.DateOfBirthComparator());
        students2.addAll(students);
        students.clear();
        students.addAll(students2);

        for (Student p : students) {
            System.out.println(p.getSurname() + " " + p.getEmail() + " " + p.getDateOfBirth());

        }

    }
}


