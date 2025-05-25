package model;

import java.util.Scanner;

public interface Option {
    void operate(Employee user, Scanner scanner, Database database, FinancialSystem financialSystem, History history);
    String getOption();
}
