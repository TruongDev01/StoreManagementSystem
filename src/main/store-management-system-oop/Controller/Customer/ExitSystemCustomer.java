package Controller.Customer;

import java.util.Scanner;

import Model.*;

public class ExitSystemCustomer implements Option2 {

    @Override
    public void operate(Customer user, Scanner s, Database database) {
        System.out.println("Exiting the system. Goodbye, " + user.getName() + "!");
        System.exit(0);
    }

    @Override
    public String getOption() {
        return "Exit System";
    }
}
