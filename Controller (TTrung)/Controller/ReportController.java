package Controller;

import History.History;
import History.ReceiptHistory;
import History.ProductHistory;
import History.EmployeeHistory;
import Model.Database;
import java.util.List;
import java.util.Date;

public class ReportController {
    private History history;
    private Database database;

    public ReportController(History history, Database database) {
        this.history = history;
        this.database = database;
    }
    
    public void FinancialReport(Date startDate, Date endDate)
    {
    	List<Receipt> receipts = history.getReceiptHistory();
    	double income = 0;
    	for(Receipt receipt : receipts)
    		if(startDate.before(receipt.getDate()) && endDate.after(receipt.getDate()))
    			income += receipt.getTotal();
    	System.out.println("From " + startDate + " to " + endDate + " earned " + income + " $.");
    }
}