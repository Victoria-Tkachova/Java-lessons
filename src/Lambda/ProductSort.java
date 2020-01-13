package Lambda;

import java.util.*;

public class ProductSort {

    <T> List<Comparable<T>> sortCollection(List<Comparable<T>> list, AlgoritmSort<T> kriterSort) {
        return list;

    }

//    ArrayList<Product> sortOfCollection(ArrayList<Product> list, int mode) {
//        ArrayList<Product> result = null;
//        if (mode >= 1 && mode <= 4) {
//            switch (mode) {
//                case 1:
//                    int changeCounter = 1;
//                    while (changeCounter > 0) {
//                        changeCounter = 0;
//                        for (int i = 0; i < list.size() - 1; i++) {
//                            if (list.get(i).getProductPrice() > list.get(i + 1).getProductPrice()) {
//                                Product temp = list.get(i);
//                                list.set(i, list.get(i + 1));
//                                list.set(i + 1, temp);
//                                changeCounter++;
//                            }
//                        }
//                    }
//                    result = list;
//                    break;
//
//                case 2:
//                    for (int i = 0; i < list.size(); i++) {
//                        Product min = list.get(i);
//                        int minId = i;
//                        for (int j = i + 1; j < list.size(); j++) {
//                        }
//                        if (list.get(j).getProductPrice() < min.getProductPrice()) {
//                            min = list.get(j);
//                            minId = j;
//                        }
//                    }
//                    Product temp = list.get(i);
//                    list.set(i, min);
//                    list.set(minId, temp);
//           //}
//            result = list;
//            break;
//
//            case 3:
//                for (int i = 1; i < list.size(); i++) {
//                    Product temp = list.get(i);
//                    int id = i - 1;
//                    while (id >= 0 && list.get(id).getProductPrice() > temp.getProductPrice()) {
//                        list.set(id + 1, list.get(id));
//                        id--;
//                    }
//                    list.set(id + 1, temp);
//                }
//                result = list;
//                break;
//
//            case 4:
//                list.stream().sorted(Product::compareByPrice).forEach(System.out::println);
//        }
//        return result;
//
//    }



    public static void main(String[] args) {
        ArrayList <Product> list = new ArrayList<>();
        list.add(new Product("Orange", 0.67f));
        list.add(new Product("Apple", 0.37f));
        list.add(new Product("Apricot", 1.01f));
        list.add(new Product("Peach", 1.23f));
        list.add(new Product("Pear", 1.58f));
        System.out.println(list);
        //Comparator<Product> compBubble
        AlgoritmSort<Product> bubble = P -> {
            int changeCounter = 1;
                    while (changeCounter > 0) {
                        changeCounter = 0;
                        for (int i = 0; i < P.size() - 1; i++) {
                            if (P.get(i).compareTo(P.get(i + 1)) > 0) {
                                Product temp =(Product) P.get(i);
                                P.set(i, P.get(i + 1));
                                P.set(i + 1, temp);
                                changeCounter++;
                            }
                        }
                    }
        };
        ProductSort obj = new ProductSort();
      //obj.sortOfCollection(list, 4);
        System.out.println(list);
    }
}
