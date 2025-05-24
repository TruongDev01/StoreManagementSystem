package Controller;

import Model.Database;
import History.History;
import Model.Employee;
import java.util.Scanner;
public class SystemController implements Option{
	Database database;
	History history;
	public SystemController(Database database, History history)
	{
		this.database = database;
		this.history = history;
	}
	
	public Employee Login()
	{
		Employee employee;
		while(1)
		{
			Scanner input = new Scanner(System.in);
			System.out.println("---------------------------------LOGIN--------------------------------");
			System.out.print("ID : ");
			int id = input.nextInt();
			System.out.print("Password : ");
			String password = input.nextLine();
			System.out.println("----------------------------------------------------------------------");
			employee = database.findEmployeeByID(id);
			if(employee != null)
			{
				System.out.println("You're connect by " + employee.getName);
				return employee;
			}
			System.out.println("Wrong ID or password!");
		}
		return null;
	}
	
	public void ExitSystem()
	{
		System.exit(0);
	}
}
