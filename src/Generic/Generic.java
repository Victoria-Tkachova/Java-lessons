package Generic;

import java.util.Comparator;

public class Generic {
    public static void main(String[] args) {
       String[] array = {"test", "Tom", "cat"};
       Integer[] array1 = {1,5,9,34};
       Generic gen = new Generic();
       gen.sortByComparator(array, new StringComparator());
    }

   <T> void  sortByComparator(T[] arr, Comparator<T> comp) {
       int changeCounter =140;
       while (changeCounter > 0) {
           changeCounter=0;
           for (int i = 0; i < arr.length - 1; i++) {
               if (compareMy(arr[i], arr[i + 1], comp) > 0) {
                   changeElement(i, arr);
                   changeCounter++;
               }
           }
       }
   }

    private <T> void changeElement(int i, T[] arr) {
        T temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }

    private <T> int compareMy(T t, T t1, Comparator<T> comp) { // обобщённые типы
        return comp.compare(t, t1);
    }


}
