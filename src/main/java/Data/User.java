package Data;

public class User {

    private int id;
    private String username;
    private String password;
    private double balance;
    private String role;

    public User(int id, String username, String password, double balance, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    @Override
    public String toString() {
        return "username: " + username + ", balance: " + balance;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public String getRole() {
        return role;
    }
}
