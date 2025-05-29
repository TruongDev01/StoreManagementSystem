package Controller.Customer;

import Model.Option2;
import java.util.Scanner;
import Model.*;
public class ViewCart implements Option2 {
    @Override
    public void operate(Customer user, Scanner scanner, Database database) {
        Cart cart = user.getCart();

        if (cart.getItems().isEmpty()) {
            System.out.println("🛒 Giỏ hàng của bạn đang trống.");
            return;
        }

        System.out.println("===== GIỎ HÀNG CỦA BẠN =====");
        for (Product p : cart.getItems()) {
            p.print(); // sử dụng phương thức print() đã được override trong mỗi loại sản phẩm
        }

        System.out.println("Tổng tiền: " + cart.getTotal() + " VND");
        System.out.println("=============================");
    }

    @Override
    public String getOption() {
        return "View Cart";
    }

}
