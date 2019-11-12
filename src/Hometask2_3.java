public class Hometask2_3 {
    public static void main(String[] args) {
        int [] testMethod = {1,3,5,7,9,11,23,48,97,102};
        int maxValue=49;
        int minValue=4;
        int [] result1 = rangeOfNumbers(testMethod, maxValue, minValue);
        System.out.println("Result:");
        for (int i=0; i<result1.length; i++) {
            System.out.println(result1[i]);
        }


    }
  public static int[] rangeOfNumbers (int[] numbers, int maxValue, int minValue) {
      int result = 0;
      for (int i = 0; i < numbers.length; i++) {
          if (numbers[i] < maxValue & numbers[i] > minValue) {
              result++;
          }
      }
      int[] res = new int[result];
      int j = 0;
      for (int i = 0; i < numbers.length; i++) {
          if (numbers[i] < maxValue & numbers[i] > minValue) {
              res[j] = numbers[i];
              j++;
          }
      }
      return res;
  }

}
