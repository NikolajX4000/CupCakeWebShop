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
     *
     * @param id the users id
     * @param username the users username
     * @param password the users password
     * @param balance the users balance
     * @param role the users role
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
     *
     * @return the users id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return the users username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return the users password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return the users balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @return the users role
     */
    public String getRole() {
        return role;
    }
}
