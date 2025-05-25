package model;

public class Book extends Product {
	private String publisher;
	private String author;
	
	public Book (String ID, String name, double purchasePrice, double sellingPrice, int qty, String publisher, String author)
	{
		super(ID, name, purchasePrice, sellingPrice, qty);
		this.publisher = publisher;
		this.author = author;
	}
	
	@Override
	public void print()
	{
		System.out.println("Book: " + name + ", Publisher: " + publisher + ", Author: " + author);
	}
}
