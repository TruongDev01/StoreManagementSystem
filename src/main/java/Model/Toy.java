package model;

public class Toy extends Product {
    private String brand;
    private String suitableAge;

    public Toy(String ID, String name, double purchasePrice, double sellingPrice, int qty,
               String brand, String suitableAge) {
        super(ID, name, purchasePrice, sellingPrice, qty);
        this.brand = brand;
        this.suitableAge = suitableAge;
    }

    @Override
    public void print() {
        System.out.println("Toy: " + name + ", Brand: " + brand + ", Suitable Age: " + suitableAge);
    }
}
