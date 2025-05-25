package model;

import java.util.ArrayList;

public class Database {
    private ArrayList<Employee> employees;
    private ArrayList<Product> products;
    private ArrayList<Receipt> receipts;

    public Database() {
        employees = new ArrayList<>();
        products = new ArrayList<>();
        receipts = new ArrayList<>();
    }

    public Product findProductByID(String id) {
        for (Product p : products) {
            if (p.ID.equals(id)) return p;
        }
        return null;
    }

    public Employee findEmployeeByID(String id) {
        for (Employee e : employees) {
            if (e.ID.equals(id)) return e;
        }
        return null;
    }

    public Receipt findReceiptByID(String id) {
        for (Receipt r : receipts) {
            if (r.ID.equals(id)) return r;
        }
        return null;
    }

    public void loadData(String employeeFilePath, String productFilePath, String databaseFile, History history) {
        // implement logic to load data
    }

    public void loadEmployees(String fileName, Database database, History history) {
        // implement logic to load employees
    }

    public void loadProducts(String fileName, Database database, History history) {
        // implement logic to load products
    }
}
