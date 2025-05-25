package model;

public abstract class Product {
	protected String ID;
	protected String name;
	protected double purchasePrice;
	protected double sellingPrice;
	protected int qty;
	public Product(String ID, String name, double purchasePrice, double sellingPrice, int qty)
	{
		this.ID = ID;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.qty = qty;
	}
	
	public abstract void print();
}
