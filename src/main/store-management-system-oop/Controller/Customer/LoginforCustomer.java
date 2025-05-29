package Controller.Customer;

import Model.*;

import java.util.Scanner;

public class LoginforCustomer implements Option2 {
    private Customer customer;
    private boolean loggedIn;
    @Override
    public void operate(Customer user, Scanner s, Database database) {
        while (true) {
            System.out.println("Welcome to HUST book store management system");
            System.out.println("Enter your email:");
            String email = s.next();
            System.out.println("Enter your password:");
            String password = s.next();
            LoginforCustomer login = new LoginforCustomer(email, password, database);

            if (login.isLoggedIn()) {
                Customer customer = login.getUser();
                System.out.println("Welcome " + customer.getName());
                customer.showList(s, database);
                break;
            } else {
                System.out.println("Wrong email or password!");
                System.out.println("1. Try again");
                System.out.println("2. Exit system");
                int choice = s.nextInt();
                if (choice == 2) {
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                }
            }
        }
    }

    public LoginforCustomer(String email, String password, Database database) {
        this.loggedIn = false;
        for (Customer c : database.getCustomers()) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                this.loggedIn = true;
                customer = c;
                c.generateOptions();
                break;
            }
        }
    }

    public LoginforCustomer() {

    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public Customer getUser() {
        return customer;
    }

    public String getOption() {
        return "LoginforController";
    }
}
