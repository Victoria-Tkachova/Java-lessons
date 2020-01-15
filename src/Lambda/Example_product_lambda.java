package Lambda;

import java.util.*;

public class Example_product_lambda {

        <T> Collection<T> sortMulti(Collection<T> collection, Comparator<T> kriteriy, AlgoritmSort<T> algor){
            return algor.sort(collection,kriteriy);
        }

        public static void main(String[] args) {
            Example_product_lambda exam = new Example_product_lambda();
            ArrayList<Product> list = new ArrayList<>();
            Collections.addAll(list, new Product("sort1",120),
                    new Product("1sort2",50),
                    new Product("sort2",30),
                    new Product("1sort2",320),
                    new Product("2sort2",208)
            );

            Comparator<Product> compPrice = (prod1,prod2)-> prod1.getProductPrice() - prod2.getProductPrice();
            Comparator<Product> compTitle = (prod1,prod2) -> prod1.getProductTitle().compareTo(prod2.getProductTitle());

            AlgoritmSort<Product> choice = (Col,Com) -> {
                Product[] arr = new Product[Col.size()];
                Col.toArray(arr);
                for (int i = 0; i <arr.length ; i++) {
                    int indexMin = findMinPosition (arr, i, Com);
                    changePlace(arr, i, indexMin);
                }
                ArrayList<Product> resultList = new ArrayList <Product> ();
                Collections.addAll(resultList, arr);
                return resultList;
            };

            AlgoritmSort <Product> bubble = (Col, Com) -> {
                Product[] arr = new Product[Col.size()];
                Col.toArray(arr);
                int changeCounter = 1;
                    while (changeCounter > 0) {
                        changeCounter = 0;
                        for (int i = 0; i < arr.length - 1; i++) {
                            if (Com.compare(arr[i],arr[i+1]) > 0) {
                                changePlace(arr, i, i+1);
                                changeCounter++;
                            }
                        }
                    }
                ArrayList<Product> resultList = new ArrayList <Product> ();
                Collections.addAll(resultList, arr);
                return resultList;
            };

            AlgoritmSort <Product> insertion = (Col, Com) -> {
                Product[] arr = new Product[Col.size()];
                Col.toArray(arr);
                for (int i = 1; i < arr.length; i++) {
                    Product temp = arr[i];
                    int id = i - 1;
                    while (id >= 0 && Com.compare(arr[id],temp) > 0) {
                        changePlace(arr, id, id+1);
                        id--;
                    }
                    arr[id+1] = temp;
                }
                ArrayList<Product> resultList = new ArrayList <Product> ();
                Collections.addAll(resultList, arr);
                return resultList;
            };

            System.out.println( exam.sortMulti(list,compPrice,insertion));
        }

        private static <K> void changePlace(K[] arr, int i, int indexMin) {
            K temp=arr[i];
            arr[i]=arr[indexMin];
            arr[indexMin]=temp;
        }

        private static <W> int findMinPosition(W[] arr, int startPosition, Comparator<W> com) {
            int minPosition=startPosition;
            for (int j = startPosition; j <arr.length ; j++) {
                if(com.compare(arr[j],arr[minPosition])<0){
                    minPosition=j;
                }
            }
            return  minPosition;
        };

}
