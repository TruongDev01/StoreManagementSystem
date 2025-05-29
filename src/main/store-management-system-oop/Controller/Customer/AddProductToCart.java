package Controller.Customer;

import Model.Customer;
import Model.Database;
import Model.Option2;
import Model.*;
import java.util.Scanner;

public class AddProductToCart implements Option2 {
    @Override
    public void operate(Customer user, Scanner scanner, Database database){

        System.out.print("Nhập ID sản phẩm cần thêm vào giỏ hàng: ");
        String productId = scanner.next();

        Product selected = database.findProductById(productId);

        if (selected == null) {
            System.out.println("❌ Không tìm thấy sản phẩm với ID: " + productId);
            return;
        }

        System.out.print("Nhập số lượng muốn mua: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println("❌ Số lượng không hợp lệ.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("❌ Số lượng phải lớn hơn 0.");
        } else if (quantity > selected.getQty()) {
            System.out.println("❌ Không đủ hàng. Hiện còn: " + selected.getQty());
        } else {
            // Clone sản phẩm và thêm vào giỏ
            Product cartItem = cloneProduct(selected, quantity);
            if (cartItem != null) {
                user.getCart().add(cartItem);
                selected.setQty(selected.getQty() - quantity);
                System.out.println("✅ Đã thêm vào giỏ: " + cartItem.getName() + " (x" + quantity + ")");
            } else {
                System.out.println("❌ Không thể thêm sản phẩm này vào giỏ (không xác định loại).");
            }
        }
    }
    private Product cloneProduct(Product original, int quantity) {
        if (original instanceof Toy toy) {
            return new Toy(toy.getID(), toy.getName(), toy.getPurchasePrice(), toy.getSellingPrice(),
                    quantity, toy.getBrand(), toy.getSuitableAge());
        }
        if (original instanceof Stationary st) {
            return new Stationary(st.getID(), st.getName(), st.getPurchasePrice(), st.getSellingPrice(),
                    quantity, st.getBrand(), st.getStationaryType());
        }
        if (original instanceof Book book) {
            return new Book(book.getID(), book.getName(), book.getPurchasePrice(), book.getSellingPrice(),
                    quantity, book.getPublisher(), book.getAuthor());
        }
        return null;
    }

    @Override
    public String getOption() {
        return "Add Product To Cart";
    }


}
