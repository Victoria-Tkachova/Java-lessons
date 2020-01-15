package Lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class ExampleproductlambdaTest {

    Example_product_lambda obj = new Example_product_lambda();
    static ArrayList <Product> list = new ArrayList<>();

    static {
        Collections.addAll(list, new Product("Orange", 20), new Product("Apple", 70), new Product("Apricot", 93)
        , new Product("Peach", 105), new Product("Pear", 99));
    }

    @Test
    void testSortingOfCollection () {
//        ArrayList<Product> positiveTesting = obj.sortOfCollection(list, 1);
//        ArrayList<Product> negativeTesting = obj.sortOfCollection(list, 5);
//        System.out.println(positiveTesting);
//        System.out.println(negativeTesting);
    }



}