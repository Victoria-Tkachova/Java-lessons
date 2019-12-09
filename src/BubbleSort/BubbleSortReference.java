package BubbleSort;

import java.util.Comparator;

public class BubbleSortReference {

    static void sortBubbleReference (String[] array) {
       for (int i = array.length -1; i > 0; i--) {
           for (int j = 0; j < i; j++) {
               if (array[j].compareTo(array[j+1]) > 0) {
                   String temp = array [j];
                   array [j] = array [j+1];
                   array [j + 1] = temp;
               }
           }
       }
    }

    public static void main(String[] args) {
        String[] array = {"abc", "a", "tyusidf", "test"};
        sortBubbleReference(array);
        for (int i =0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
