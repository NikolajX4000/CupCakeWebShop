    package DBConnection;

import Data.CupCakePiece;
import Data.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private DBConnector conn = new DBConnector();

    public User getUser(String u) {
        PreparedStatement stmt = null;
        User res = null;
        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            stmt = conn.getConnection().prepareStatement(sql);
            stmt.setString(1, u);
            ResultSet rs = stmt.executeQuery();
            if (rs.first()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                double balance = rs.getDouble("balance");
                String role = rs.getString("role");
                res = new User(id, username, password, balance, role);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return res;
    }
    
    public ArrayList<User> getUsers() {
        PreparedStatement stmt = null;
        ArrayList<User> users = new ArrayList();
        try {
            String sql = "SELECT * FROM users;";
            stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                double balance = rs.getDouble("balance");
                String role = rs.getString("role");
                users.add( new User(id, username, password, balance, role));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return users;
    }

    public boolean createCustomer(String username, String password1, String password2) {
        PreparedStatement stmt = null;
        boolean createdCustomer = password1.equals(password2);
        if (createdCustomer) {
            try {
                String sql = "INSERT INTO users (username, password) VALUES (?,?);";
                stmt = conn.getConnection().prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password1);
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return createdCustomer;
    }

    public boolean createAdmin(String username, String password1, String password2) {
        PreparedStatement stmt = null;
        boolean createdAdmin = password1.equals(password2);
        if (createdAdmin) {
            try {
                String sql = "INSERT INTO users (username, password, role) VALUES (?,?, 'Admin');";
                stmt = conn.getConnection().prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password1);
                stmt.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return createdAdmin;
    }

    public ArrayList<CupCakePiece> getToppings() {
        ArrayList<CupCakePiece> toppings = new ArrayList();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM toppings;";
            stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String flavor = rs.getString("topping");
                double price = rs.getDouble("price");
                toppings.add(new CupCakePiece(id, flavor, price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return toppings;
    }

    public ArrayList<CupCakePiece> getBottoms() {
        ArrayList<CupCakePiece> bottoms = new ArrayList();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM bottoms;";
            stmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String flavor = rs.getString("bottom");
                double price = rs.getDouble("price");
                bottoms.add(new CupCakePiece(id, flavor, price));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return bottoms;
    }

    public User login(String username, String password) {
        PreparedStatement stmt = null;
        User user = null;
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ? ;";
            stmt = conn.getConnection().prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("role"), rs.getDouble("balance"), rs.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return user;
    }
}
