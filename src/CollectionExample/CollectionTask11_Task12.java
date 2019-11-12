package CollectionExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTask11_Task12 {

    public static void main(String[] args) {
        ArrayList<Integer> newCollection = new ArrayList<>();
        newCollection.add(13);
        newCollection.add(567);
        newCollection.add(138);
        newCollection.add(75);
        newCollection.add(16);
       int resultSum = sum(newCollection);
        System.out.println("Sum of all the elements in the collection: " + resultSum);
        int comparator = 86;
        System.out.println(newCollection);
        deletedElementsIterator (newCollection, comparator);
        System.out.println(newCollection);
    }

    static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum; // метод, который выводит сумму элементов
    }

    static void deletedelements (ArrayList<Integer> List, int iComparable) {
        for (int i=0; i < List.size(); i++) {
        if (List.get(i) < iComparable) {
            List.remove(i);
        }
    }
    }
    static void deletedElementsIterator (ArrayList<Integer> List, int iComparable) {
        Iterator <Integer> iteratorDeletion = List.iterator();
        while (iteratorDeletion.hasNext()) {
            if (iteratorDeletion.next() < iComparable) {
                iteratorDeletion.remove();
            }
        }
    }
} // метод, который удаляет числа, которые меньше заданного элемента


