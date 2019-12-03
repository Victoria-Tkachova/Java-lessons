package CollectionComparator;

import java.util.*;

public class Student {
   String lastName;
   float averageMark;
   int age;

   Student (String lastName, int age, float averageMark) {
       this.lastName = lastName;
       this.averageMark = averageMark;
       this.age = age;
   }

   String getLastName() {return lastName;}
   int getAge() {return age;}
   float getAverageMark() {return averageMark; }

   void chooseSortingModel(List<Student> list) {
       System.out.println("Choose one of three models of comparing: ");
       while (true) {
           Scanner scan = new Scanner(System.in);
           if (scan.hasNextInt()) {
               int mode = scan.nextInt();
                   switch (mode) {
                       case 1:
                           Collections.sort(list, new LastNameComparator());
                           break;
                       case 2:
                           Collections.sort(list, new AgeComparator());
                           break;
                       case 3:
                           Collections.sort(list, new AverageMarkComparator());
                           break;
                       default:
                           System.out.println("Please choose the number from 1 to 3. Thank you!");
                           continue;
                   }
           }
           else {
              System.out.println("This is not a number. Please try again!");
              continue;
           }
           break;
       }

   }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", averageMark=" + averageMark +
                ", age=" + age +
                '}';
    }
}
