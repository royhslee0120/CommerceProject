package commerce;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<Product> products;

    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}
