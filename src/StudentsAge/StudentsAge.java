package StudentsAge;

import java.util.ArrayList;

public class StudentsAge {
    ArrayList<Integer> studentsAgeGenerator(int totalNumberStudents, int wrongAgeNumber) {
        ArrayList<Integer> studentsAgeList = new ArrayList<Integer>();
        int minAge = 17;
        int maxAge = 22;
        for (int i = 0; i < totalNumberStudents; i++) {
            if (i < wrongAgeNumber) {
                studentsAgeList.add((int) (minAge * Math.random()));
            } else {
                studentsAgeList.add((int) (Math.random() * (maxAge - minAge + 1) + minAge));
            }
        }
        return studentsAgeList;
    }

    int averageAgeCounter(ArrayList<Integer> studentsAgeList) {
        int result = 0;
        ArrayList <Integer> resultTemp = new ArrayList<Integer>();
        int resultTempSum = 0;
        for (int i = 0; i < studentsAgeList.size(); i++) {
            if (studentsAgeList.get(i) >= 17 && studentsAgeList.get(i) <= 22) {
               resultTemp.add(studentsAgeList.get(i));

            }
            else {
                try {
                    throw new AgeException("Age exception");
                } catch (AgeException aex) {
                    System.out.println("Age exception!");
                }
            }
        }
        for (int i : resultTemp) {
            resultTempSum += i;
        }
        result =  resultTempSum/ resultTemp.size();
        return result;
    }



    public static void main(String[] args) {
        StudentsAge obj1 = new StudentsAge();
        ArrayList<Integer> studentsAgeList = obj1.studentsAgeGenerator(25, 12);
        System.out.println(studentsAgeList.toString());
        int result = obj1.averageAgeCounter(studentsAgeList);
        System.out.println(result);

    }
}
