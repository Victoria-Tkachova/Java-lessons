package Hometask_20_01_2020;

public class Student {

    private String name;
    private String specialty;
    private int age;
    private int course;
    private int height;

    Student (String name, int age, int height, String specialty, int course) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.specialty = specialty;
        this.course = course;
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    public int getCourse() { return course; }

    public int getHeight() { return height; }

    public String getSpecialty() { return specialty; }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", age=" + age +
                ", course=" + course +
                ", height=" + height +
                '}';
    }
}
