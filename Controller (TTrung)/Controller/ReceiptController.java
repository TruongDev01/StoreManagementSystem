package Controller;

import Model.Receipt;
import Model.ProductHistory;
import Model.Product;
import Model.Employee;
import Model.Customer;
import Model.Database;
import History.History;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class ReceiptController {
	private Database database;
	private History history;
	public ReceiptController (Database database, History history) {
		this.database = database;
		this.history = history;
	}
	
	public void createReceipt (Employee employee)
	{
		if(employee == null)
			return null;
		
		String id;
		double total = 0;
		Scanner input = new Scanner(System.in);
		Receipt recept = new Receipt();
		System.out.println("Input receipt ID: ");
		id = input.nextLine();
		while(database.findReceiptByID(id) != null)
		{
			System.out.println("This receipt ID has already exist!");
			System.out.println("Input receipt ID: ");
			id = input.nextLine();
		}
		receipt.setID(id);
		id++;
		receipt.setCashier(employee);
		
		List<Product> products = new List<Product>;
		System.out.println("Input product ID: (end by #)");
		String productId = input.nextLine();
		while(!productId.equals("#"))
		{
			Product product = findProductByID(productId);
			if(product != NULL)
			{
				products.add(product);
				System.out.println("Add completed!");
				total = total + product.sellingPrice;
			}
			else
				System.out.println("Cannot find product with that ID!");
			productId = input.nextInt();
		}
		receipt.setProducts(products);
		receipt.setTotal(total);
		
		int payment;
		System.out.println("How to pay?");
		System.out.println("1. Cash");
		System.out.println("2. Banking");
		System.out.println("3. Card");
		payment = input.nextInt();
		while(payment != 1 && payment != 2 && payment != 3)
		{
			System.out.println("Incorrect! Please input again.");
			payment = input.nextInt();
		}
		receipt.setPayment(payment);
		
		if(payment == 1) 
		{
			System.out.println("Paid :");
			double paid = input.nextDouble();
			receipt.setPaid(paid);
			receipt.setChange(total - paid);
			System.out.println("Change: " + (total - paid));
		}
		
		receipt.setDate(new Date());
		return receipt;
	}
	
	public void ReadReceipt(Receipt receipt)
	{
		System.out.println("---------------------------Reciept--------------------------");
		System.out.println("Receipt ID : " + receipt.getID());
		System.out.println("Cashier : " + receipt.getCashier());
		System.out.println("Day : " + receipt.getDate());
		List<Product> products = receipt.getProducts();
		System.out.println("Number | Product ID | Product name                  | Price");
		for(int i=1; products[i] != null; i++)
			System.out.println(  i + " | " + products[i].getID() + " | " + products[i].getName() + " | " + products[i].getPrice());
		System.out.println("Total : " + receipt.getTotal());
		System.out.println("Payment : " + receipt.getPayment() == 1 ? "Cash" : (receipt.getPayment() == 2 ? "Banking" : "Card"));
		if(receipt.getPayment() == 1)
		{
			System.out.println("Paid : " + receipt.getPaid());
			System.out.println("Change : " + receipt.getChange());
		}
		System.out.println("------------------------------------------------------------");
	}
	
	public void ReadMyReceipt()
	{
		List<Receipt> receipts = history.getReceiptHistory();
		for(Receipt receipt : receipts)
		{
			ReadReceipt(receipt);
		}
	}
	
	public void ReadAllReceipt()
	{
		List<Receipt> receipts = database.getReceiptHistory();
		for(Receipt receipt : receipts)
		{
			ReadReceipt(receipt);
		}
	}
	
	public void ReadCashierRecept(String cashierID)
	{
		Employee cashier = database.findEmloyeeByID(cashierID);
		if(cashier == null)
		{
			System.out.println("Cannot find cashier with that ID!");
			return;
		}
		
		List<Receipt> receipts = history.getReceiptHistory();
		for(Receipt receipt : receipts)
		{
			if(cashier.equals(receipt.getCashier()))
				ReadReceipt(receipt);
		}
	}
	public void DeleteReceipt(String receiptId)
	{
		Receipt receipt = database.findReceiptByID(receiptId);
		if(receipt == null) 
		{
			System.out.println("Cannot find receipt with thay ID!");
			return;
		}
		List<Receipt> receipts = database.getReceipt();
		receipts.remove(receipt);
		database.loadReceipt(receipts);
	}
}
