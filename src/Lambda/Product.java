package Lambda;

public class Product {
    String productTitle;
    float productPrice;

    Product (String productTitle, float productPrice) {
        this.productPrice = productPrice;
        this.productTitle = productTitle;
    }

    String getProductTitle () { return productTitle; }
    float getProductPrice () { return productPrice; }
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
}
