package CollectionExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTask16 {

}
class Student implements Comparable<Student> {
    String surname;

    Student(String surname) {
        this.surname = surname;
    }

    String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Student s) {
        return surname.compareTo(s.getSurname());
    }
}
     class University {
         Set<Student> students = new TreeSet<Student>();

         void removeFromUniversity(ArrayList<Student> spisok, String lastName) {
             Iterator<Student> iteratorRemoving = spisok.iterator();
             while (iteratorRemoving.hasNext()) {
                 if ((iteratorRemoving.next().getSurname()).equals(lastName)) {
                     iteratorRemoving.remove();
                     break;
                 }
             }
         }

         boolean takeToUniversity(String lastName) {
             boolean result;
             Student newStudent = new Student(lastName);
                 result=students.add(newStudent);
            return result;
         }





        public static void main(String[] args) {
             University un1=new University();
            ArrayList<Student> spisok = new ArrayList<>();
            Student student1 = new Student("Иванов");
            Student student2 = new Student("Петров");
            Student student3 = new Student("Сидоров");
            Student student4 = new Student("Козлов");
            Student student5 = new Student("Петряков");
            Student student6 = new Student("Трянов");
            Student student7 = new Student("Игуменов");
            Student student8 = new Student("Мордатов");
            Student student9 = new Student("Рыжков");
            Student student10 = new Student("Лисичкин");

            spisok.add(student1);
            spisok.add(student2);
            spisok.add(student3);
            spisok.add(student4);
            spisok.add(student5);
            spisok.add(student6);
            spisok.add(student7);
            spisok.add(student8);
            spisok.add(student9);
            spisok.add(student10);

            for (Student p : spisok) {
                System.out.println("В университете учатся: " + p.getSurname());
            }

            un1.removeFromUniversity(spisok, "Иванов");

            for (Student p : spisok) {
                System.out.println("После отчисления в университете остались: " + p.getSurname());
            }

            un1.takeToUniversity("Ткачёв");

            for (Student p: spisok) {
                System.out.println("После зачисления в университете учатся: " + p.getSurname());
            }

        }



    }







