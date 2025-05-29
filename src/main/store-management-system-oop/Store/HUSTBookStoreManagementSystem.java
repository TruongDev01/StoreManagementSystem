package Store;

import java.util.Scanner;

import Controller.Customer.LoginforCustomer;
import Controller.Employee.Login;
import History.History;
import Model.*;

public class HUSTBookStoreManagementSystem {
    public static void main(String[] args) {
        Database database = new Database();
        FinancialSystem financialSystem = new FinancialSystem(1000000000.0);
        History history = new History();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Working directory: " + System.getProperty("user.dir"));

        // Load dữ liệu
        database.loadData("Store/employees.csv", "Store/products.csv", "Store/customers.csv", database, history);

        // Chọn vai trò đăng nhập
        int roleChoice = 0;
        while (roleChoice != 1 && roleChoice != 2) {
            System.out.println("Welcome to HUST Bookstore Management System");
            System.out.println("Please select your role:");
            System.out.println("1. Employee");
            System.out.println("2. Customer");
            System.out.print("Your choice: ");
            try {
                roleChoice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                roleChoice = 0;
            }
            if (roleChoice != 1 && roleChoice != 2) {
                System.out.println("Invalid choice. Please select 1 or 2.\n");
            }
        }

        // Gọi Login với vai trò tương ứng
        if (roleChoice == 1) {
            new Login().operate(null, scanner, database, financialSystem, history); // nhân viên
        } else {
            new LoginforCustomer().operate(null,scanner, database); // khách hàng
        }

        scanner.close();
    }
}
