package BubbleSort;

import java.util.Comparator;

public class BubbleSortReference {

    void sortBubbleReference (String[] array, Comparator <String> comp) {
        int changeCounter = 100;
        while (changeCounter > 0) {
            changeCounter=0;
            for (int i = 0; i < array.length - 1; i++) {
                if (compareByComparator(array[i], array[i + 1], comp) > 0) {
                    changeString(i, array);
                    changeCounter++;
                }
            }
        }
    }

    int compareByComparator (String i, String i1, Comparator<String> comp) {
        return comp.compare(i,i1);
    }

    void changeString (int index, String[] array) {
        String temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }


    public static void main(String[] args) {
        String[] array = {"abc", "a", "tyusidf", "test"};
        BubbleSortReference obj = new BubbleSortReference();
        obj.sortBubbleReference(array, new StringComparator1());
        for (int i =0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
