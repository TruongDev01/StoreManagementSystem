package model;

public class FinancialSystem {
    private double capital;

    public void addRevenue(double revenue) {
        capital += revenue;
    }

    public void subtractCost(double cost) {
        capital -= cost;
    }

    public double calculateNetProfit(double revenue, double costOfGoodsAdded, double totalSalaries) {
        return revenue - costOfGoodsAdded - totalSalaries;
    }
}
