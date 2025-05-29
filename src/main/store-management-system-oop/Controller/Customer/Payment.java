package Controller.Customer;

import Model.*;
import java.util.List;
import java.util.Scanner;
public class Payment implements Option2 {
    @Override
    public void operate(Customer customer, Scanner scanner, Database database) {
        Cart cart = customer.getCart();
        List<Product> items = cart.getItems();

        if (items.isEmpty()) {
            System.out.println("❌ Giỏ hàng đang trống. Không thể thanh toán.");
            return;
        }

        System.out.println("🛒 Giỏ hàng của bạn:");
        for (Product p : items) {
            System.out.println("- " + p.getName() + " | Số lượng: " + p.getQty() + " | Giá: " + p.getSellingPrice() + " VND");
        }

        double total = cart.getTotal();
        System.out.println("💰 Tổng tiền: " + total + " VND");

        System.out.println("✅ Thanh toán thành công! Cảm ơn bạn đã mua hàng.");

        cart.clear(); // Xóa toàn bộ giỏ hàng
    }

    @Override
    public String getOption() {
        return "Payment";
    }


}
