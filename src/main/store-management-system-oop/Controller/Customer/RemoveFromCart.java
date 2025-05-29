package Controller.Customer;

import Model.*;
import java.util.Scanner;

public class RemoveFromCart implements Option2 {

    @Override
    public void operate(Customer user, Scanner scanner, Database database) {
        Cart cart = user.getCart();

        if (cart.getItems().isEmpty()) {
            System.out.println("❌ Giỏ hàng đang trống. Không thể xoá sản phẩm.");
            return;
        }


        System.out.print("Nhập ID sản phẩm muốn xoá khỏi giỏ hàng: ");
        String productId = scanner.next();

        boolean removed = cart.remove(productId);

        if (removed) {
            System.out.println("✅ Đã xoá sản phẩm có ID: " + productId);
        } else {
            System.out.println("❌ Không tìm thấy sản phẩm có ID: " + productId + " trong giỏ hàng.");
        }
    }

    @Override
    public String getOption() {
        return "Remove Product From Cart";
    }
}
