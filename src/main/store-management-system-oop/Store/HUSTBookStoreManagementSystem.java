package Store;

import java.util.Scanner;
import Controller.*;
import History.History;
import Model.*;

public class HUSTBookStoreManagementSystem {
    public static void main(String[] args) {
        Database database = new Database();
        FinancialSystem financialSystem = new FinancialSystem(1000000000.0);
        History history = new History();
        System.out.println("Working directory: " + System.getProperty("user.dir"));

        // Load employees and products
        database.loadData("Store/employees.csv", "Store/products.csv", database, history);

        new Login().operate(null, new Scanner(System.in), database, financialSystem, history);
    }
}
