package Model;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void add(Product product) {
        items.add(product);
    }

    public boolean remove(String productId) {
        return items.removeIf(p -> p.getID().equalsIgnoreCase(productId));
    }


    public List<Product> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public double getTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getSellingPrice()* p.getQty();
        }
        return total;
    }
}
