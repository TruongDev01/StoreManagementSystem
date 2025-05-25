package model;

import java.util.Optional;
import java.util.Scanner;

public class Employee {
    protected String ID;
    protected String name;
    protected String email;
    protected String password;
    protected int department;
    protected Optional<Option> options;
    protected double salary;

    public Employee() {
        this.options = Optional.empty();
    }

    public Employee(String ID, String name, String email, String password, double salary) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.options = Optional.empty();
    }

    public void generateOptions() {
        // implement logic
    }

    public void print() {
        System.out.println("Employee ID: " + ID + ", Name: " + name + ", Email: " + email);
    }

    public void showList(Scanner scanner, Database database, FinancialSystem financialSystem, History history) {
        // implement logic
    }
}
