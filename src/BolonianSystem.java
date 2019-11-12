public class BolonianSystem {
    public static void main(String[] args) {
    int grade = 67;
    int result = bolonianSystem(grade);
        System.out.println("Result: " + result);
        int grade1 = 60;
        int result1 = bolonianSystem(grade1);
        System.out.println("Result: " + result1);
        int grade2 = -1;
        int result2 = bolonianSystem(grade2);
        System.out.println("Result: " + result2);
        int grade3 = 101;
        int result3 = bolonianSystem(grade3);
        System.out.println("Result: " + result3);
        int grade4 = 0;
        int result4 = bolonianSystem(grade4);
        System.out.println("Result: " + result4);
        int grade5 = 1;
        int result5 = bolonianSystem(grade5);
        System.out.println(result5);
        int grade6 = 100;
        int result6 = bolonianSystem(grade6);
        System.out.println(result6);
    }
    public static int bolonianSystem (int grade) {
        int result = 0;
        if (grade>0 && grade<60) {
            result = 2;
        }
        if (grade>59 && grade<75) {
            result = 3;
        }
        if (grade>74 && grade<90) {
            result = 4;
        }
        if (grade>89 && grade<=100) {
            result = 5;
        }
        return result;
    }

}
