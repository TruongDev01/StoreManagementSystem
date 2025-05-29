package Model;

public abstract class User {
    protected String ID;
    protected String name;
    protected String email;
    protected String password;
    public User(){

    }
    public User(String ID,String name, String email, String password){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String getID() {
        return ID;
    }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
}
