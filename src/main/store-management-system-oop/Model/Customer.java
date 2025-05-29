package Model;

import Controller.Customer.*;

import java.util.Scanner;

public class Customer extends User  {

    private Cart cart;
    protected Option2[] options ; //option để cho nhân viên lựa chọn
    public Customer(){
        generateOptions();
    }

    public Customer(String id, String name, String email, String password) {
        super( id, name, email, password);
        this.cart = new Cart();
        generateOptions();
    }
    public void generateOptions(){
        this.options = new Option2[] {
                new AddProductToCart(),
                new ViewCart(),
                new RemoveFromCart(),
                new Payment(),
                new ExitSystemCustomer(),
        };
    }


    public Cart getCart() {
        return cart;
    }
    public void showList(Scanner s, Database database) {
        System.out.println("-----------------------");
        for (int i=1; i<=options.length; i++) {
            System.out.println(i+". "+options[i-1].getOption()); //show ra menu để đối tượng có thể chọn
        }
        System.out.println("-----------------------");

        int selected = s.nextInt();
        options[selected-1].operate(this, s, database);
        showList(s, database);
    }




}
