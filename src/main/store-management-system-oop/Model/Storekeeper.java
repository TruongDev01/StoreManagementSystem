package Model;

import Controller.Employee.*;

public class Storekeeper extends Employee {

	public Storekeeper(){
		generateOptions();
	}

	public Storekeeper(String ID, String name, String email,String password, double salary) {
		super(ID,name,email,password,salary);
		generateOptions();
	}

	public void generateOptions() {
        this.options = new Option[] {
			new UpdateProduct(),
			new ReadAllProducts(),
			new ReadAllProductsByType(),
			new ChangePassword(),
			new ExitSystem(),
        };
	}
	
	@Override
	public int getDepartment() {
		return 2;
	}

}

