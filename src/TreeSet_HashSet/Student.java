package TreeSet_HashSet;

import java.util.Comparator;

public class Student {
    private String lastName;
    private String email;

    Student (String lastName, String email) {
        this.lastName = lastName;
        this.email = email;
    }

    String getLastName() {return lastName; }
    String getEmail() {return email; }

    public static class StudentEmailComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getEmail().compareTo(o2.getEmail());
        }
    }

}
