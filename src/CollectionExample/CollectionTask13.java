package CollectionExample;

import java.util.*;

public class CollectionTask13 {
    public static void main(String[] args) {
    ArrayList <Integer> testList = new ArrayList<>();
    testList.add(34);
    testList.add(678);
    testList.add(34);
    testList.add(678);
    testList.add(15);
    testList.add(26);
    testList.add(42);
    numberOfNumbers(testList);
    frequenceNumbers(testList);
    }

    static void numberOfNumbers(ArrayList<Integer> ourList) {
        TreeSet<Integer> ourTree = new TreeSet<Integer>();
        ourTree.addAll(ourList);
        for (Integer currEl : ourTree) {
            System.out.println("Число: " + currEl + " повторяется " + Collections.frequency(ourList, currEl) + " раз(а)");
        }
    }
    static void frequenceNumbers (List<Integer> ourList) {
        TreeMap <Integer, Integer> ourMap = new TreeMap<>();
        for (int i:ourList) {
            Integer numberValue = ourMap.get(i);
            if (numberValue == null) {
                ourMap.put(i, 1);
            }
            else {
                ourMap.put (i, numberValue+1);
            }
        }
        System.out.println(ourMap);
    }
}
