package CollectionExample;

import java.util.TreeSet;

public class CollectionTask15 {
    public static void main(String[] args) {
        class Student implements Comparable <Student> {
            String surname;
            float middleMarks;
            int scholarship;

            Student (String n, float mm, int s) {
               surname = n;
               middleMarks = mm;
               scholarship = s;
                System.out.println("У студента " + n + " средний балл успеваемости " + mm + " и размер стипендии " + s);
            }

            Student () {
                surname = "Нет такого студента";
                middleMarks = 0.0f;
                scholarship = 0;
            }

            Student (String n, int contractNumber) {
                System.out.println("Студент " + n + " учится на котракте № " + contractNumber + " поэтому не получает стипендии");
            }

            Student (String surname) {
                this.surname = surname;
            }
            String getSurname () { return surname; }

            @Override
            public int compareTo(Student s) {
                return surname.compareTo(s.getSurname());
            }
        }
        Student student1 = new Student ("Иванов", 4.5f, 2500);
        Student student2 = new Student ("Петров", 4.0f, 2000);
        Student student3 = new Student ();
        Student student4 = new Student ("Сидоров", 4567);

        TreeSet<Student> student = new TreeSet<Student>();
        student.add (new Student("Александров"));
        student.add (new Student("Ткачёва"));
        student.add (new Student("Рябкова"));
        student.add (new Student("Синицын"));
        student.add (new Student("Воронцов"));
        student.add (new Student("Акунин"));

        for (Student s : student) {
            System.out.println(s.getSurname());
        }

    }
}
