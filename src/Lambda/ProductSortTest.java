package Lambda;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ProductSortTest {

    ProductSort obj = new ProductSort();
    static ArrayList <Product> list = new ArrayList<>();

    static {
        Collections.addAll(list, new Product("Orange", 0.67f), new Product("Apple", 0.37f), new Product("Apricot", 1.01f)
        , new Product("Peach", 1.23f), new Product("Pear", 1.58f));
    }

    @Test
    void testSortingOfCollection () {
        ArrayList<Product> positiveTesting = obj.sortOfCollection(list, 1);
        ArrayList<Product> negativeTesting = obj.sortOfCollection(list, 5);
        System.out.println(positiveTesting);
        System.out.println(negativeTesting);
    }



}