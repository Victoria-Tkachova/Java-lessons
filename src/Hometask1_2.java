public class Hometask1_2 {
    public static void main(String[] args) {
        int maxValue = 25, minValue = 1;
        int[] values = {0, 1, 2, 24, 25, 26};
        for (int i = 0; i < values.length; i++) {
            if (values[i] > minValue & values[i] < maxValue) {
                System.out.println("\nTrue");
            } else {
                System.out.println("\nFalse");
            }

        }
    }
}
