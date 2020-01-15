package Lambda;

import java.util.ArrayList;
import java.util.List;

public class Streams_Hometask1 {

    void sortDiapasonPrices (List<Product> list, int diap1, int diap2) {
        if (diap1 < diap2) {
            list.stream().filter(P -> P.getProductPrice() > diap1 && P.getProductPrice() < diap2).forEach(System.out::println);
        }
        else {
            list.stream().filter(P -> P.getProductPrice() < diap1 && P.getProductPrice() > diap2).forEach(System.out::println);
        }

    }

    Double sumOfAllProducts (List<Product> list) {
        return list.stream().mapToDouble(Product::getProductPrice).sum();
    }

    Product[] sortDiapasonArray (List<Product> list, int diap1, int diap2) {
        return list.stream().filter(P -> P.getProductPrice() > diap1 && P.getProductPrice() < diap2).toArray(Product[]::new);
    }

    public static void main(String[] args) {
        ArrayList <Product> list = new ArrayList<>();
        list.add(new Product("Orange", 30));
        list.add(new Product("Apple", 62));
        list.add(new Product("Apricot", 78));
        list.add(new Product("Peach", 101));
        list.add(new Product("Pear", 25));
        Streams_Hometask1 obj = new Streams_Hometask1();
        obj.sortDiapasonPrices(list, 0, 1);
        System.out.println(obj.sumOfAllProducts(list));
        obj.sortDiapasonArray(list, 0,1);
    }



}
