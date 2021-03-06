package Lambda;

import java.util.Comparator;

public class Product implements Comparable <Product> {
    String productTitle;
    int productPrice;

    Product (String productTitle, int productPrice) {
        this.productPrice = productPrice;
        this.productTitle = productTitle;
    }

    String getProductTitle () { return productTitle; }
    int getProductPrice () { return productPrice; }
// ?????????????????
    public int compareByPrice(Product p) {
        return productPrice > p.getProductPrice() ? 1 : (productPrice == p.getProductPrice() ? 0 : -1);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }



    @Override
    public int compareTo(Product o) {
        return Float.floatToIntBits(this.getProductPrice())-Float.floatToIntBits(o.getProductPrice());
    }
}
