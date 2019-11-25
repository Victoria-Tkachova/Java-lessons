package StudentsAge;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class Student {
    String lastName;
    int age;
    static ArrayList<String> listStudentsNames = new ArrayList<>();

    static {
        Collections.addAll(listStudentsNames, "Иванов", "Петров", "Ткачёва", "Белов", "Беляев");
    }

    Student(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }

    List<Student> studentsGenerator(int totalNumberStudents, int wrongAgeNumber) {
        List<Student> result = new ArrayList<Student>();
        Random generator = new Random();
        int numberOfAddedWrongAge = 0;
        for (int i = 0; i < totalNumberStudents; i++) {
            int indexOfName = generator.nextInt(listStudentsNames.size() - 1);
            int randomAge = generator.nextInt(25);
            if (randomAge > 17 && randomAge < 22) {
                result.add (new Student(listStudentsNames.get(indexOfName), randomAge));

            }
            else {

                if (numberOfAddedWrongAge < wrongAgeNumber) {
                    numberOfAddedWrongAge ++;
                    result.add (new Student(listStudentsNames.get(indexOfName), randomAge));
                }else{
                    i--;
                }

            }


        }
        return result;
    }

    List<Student> studentsGenerator1(int totalNumberStudents, int wrongAgeNumber) {
        List<Student> result = new ArrayList<Student>();
        Random generator = new Random();
        int numberOfAddedWrongAge = 0;
        while (result.size() < totalNumberStudents) {
            int indexOfName = generator.nextInt(listStudentsNames.size() - 1);
            int randomAge = generator.nextInt(25);
            if (randomAge > 17 && randomAge < 22) {
                result.add (new Student(listStudentsNames.get(indexOfName), randomAge));
            }
            else {
                if (numberOfAddedWrongAge < wrongAgeNumber) {
                    numberOfAddedWrongAge ++;
                    result.add (new Student(listStudentsNames.get(indexOfName), randomAge));
                }

            }


        }
        return result;
    }

    float averageAge (List <Student> studentList) {
        float result = 0;
        int sum = 0;
        int rightAgeCount = 0;
        for (Student i : studentList) {
            if (i.age > 17 && i.age < 22) {
                sum += i.age;
                rightAgeCount++;
            } else {
                try {
                    throw new AgeException("Age Exception");
                } catch (AgeException aex) {
                    new AgeException("Age Exception!", aex);
                }
            }

        }
        result = sum / rightAgeCount;
        return result;
    }

    public static void main(String[] args) {
        Student obj = new Student("Петров", 17);
        Student obj1 = new Student ("Иванов", 17);
        List <Student> list1 =  obj.studentsGenerator(5, 2);
        System.out.println(list1);

        float result1 = obj.averageAge(list1);
        System.out.println(result1);

        HashSet <Student> hashSet1 = new HashSet<>();
        hashSet1.add(obj);
        hashSet1.add (obj1);
        hashSet1.add (obj1);
        hashSet1.add (obj1);

        System.out.println(hashSet1);


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
