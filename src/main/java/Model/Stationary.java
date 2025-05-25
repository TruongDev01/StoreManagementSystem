package model;

public class Stationary extends Product {
    private String stationaryType;

    public Stationary(String ID, String name, double purchasePrice, double sellingPrice, int qty,
                      String stationaryType) {
        super(ID, name, purchasePrice, sellingPrice, qty);
        this.stationaryType = stationaryType;
    }

    @Override
    public void print() {
        System.out.println("Stationary: " + name + ", Type: " + stationaryType);
    }
}
