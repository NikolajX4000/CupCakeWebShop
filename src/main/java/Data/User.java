package Data;

/**
 * @author Daniel Lindholm, Jacob Borg, Nikolaj Thorsen Nielsen, Stephan Marcus Duelund Djurhuus
 */
public class User {

    private int id;
    private String username;
    private String password;
    private double balance;
    private String role;

    /**
     * Constructor.
     * 
     * @param id the users id, should be not null
     * @param username the users username, should be not null
     * @param password the users password, should be not null
     * @param balance the users balance, should be not null
     * @param role the users role, should be not null
     */
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

    /**
     * Returns the id.
     * 
     * @return the users id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the username.
     * 
     * @return the users username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password.
     * 
     * @return the users password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the balance.
     * 
     * @return the users balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the role.
     * 
     * @return the users role
     */
    public String getRole() {
        return role;
    }
}
