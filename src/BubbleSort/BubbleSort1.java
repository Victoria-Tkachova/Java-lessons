package BubbleSort;

public class BubbleSort1 {
    static void bubbleSort (int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array [j];
                    array [j] = array [j+1];
                    array [j+1] = temp;
                }
            }
        }
    }

    static void binarySearch (int[] array, int item) {
        int first = 0;
        int last = array.length - 1;
        int comparisonCounter = 1;
        int position = (first+last) / 2;
        while ((array[position] != item) && (first <= last)) {
            comparisonCounter++;
            if (array[position] > item) {
                last = position - 1;
            }
            else {
                first = position + 1;
            }
            position = (first+last) / 2;
        }
        if (first <= last) {
            System.out.println("\n" + item + " is " + ++position + " element in the array.");
            System.out.println("The number of comparisons is " + comparisonCounter);
        }
        else {
            System.out.println("\nThere is no such element in the array! The number of comparisons is " + comparisonCounter);
        }
    }
    public static void main(String[] args) {
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array [i] = (int)(Math.random() * 10);
        }
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        binarySearch(array, 9);
    }
}
