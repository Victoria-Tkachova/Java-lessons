package Lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class Streams_Hometask1Test {

    Streams_Hometask1 obj = new Streams_Hometask1();
    static ArrayList<Product> list = new ArrayList<>();

    static {
        Collections.addAll(list, new Product("Orange", 30), new Product("Apple", 62), new Product("Apricot", 28)
                , new Product("Peach", 115), new Product("Pear", 112));
    }

    @Test
    void testSortDiapasonPrices () {
        obj.sortDiapasonPrices(list, 0, 1);
        obj.sortDiapasonPrices(list, 2,5);
    }

    @Test
    void testSumOfAllProducts () {
        Double positiveTesting = obj.sumOfAllProducts(list);
    }

    @Test
    void testSortDiapasonArray () {
        Product[] testArray = obj.sortDiapasonArray(list, 0, 1);
    }


}