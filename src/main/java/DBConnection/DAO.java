package DBConnection;

import Data.CupCakePiece;
import Data.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                users.add(new User(id, username, password, balance, role));
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

    public CupCakePiece getTopping(int id) {
        String topping = "";
        double price = 0.0;
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM toppings where id = ?;";
            stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.first()) {
                return null;
            }
            topping = rs.getString("topping");
            price = rs.getDouble("price");
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
        return new CupCakePiece(id, topping, price);
    }

    public CupCakePiece getBottom(int id) {
        String bottom = "";
        double price = 0.0;
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM bottoms where id = ?;";
            stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.first()) {
                return null;
            }
            bottom = rs.getString("bottom");
            price = rs.getDouble("price");
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
        return new CupCakePiece(id, bottom, price);
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

    public Order getOrder(int id) {
        ArrayList<OrderLine> orderlines = new ArrayList();
        PreparedStatement stmt = null;
        Order order = null;
        String dateTime = null;
        try {
            String sql = "SELECT * "
                    + "FROM orderline "
                    + "INNER JOIN orders "
                    + "ON orders.id=orderline.order_id "
                    + "INNER JOIN toppings "
                    + "ON toppings.id=orderline.topping_id "
                    + "INNER JOIN bottoms "
                    + "ON bottoms.id=orderline.bottom_id "
                    + "INNER JOIN users "
                    + "ON users.user_id=orders.user_id "
                    + "WHERE order_id = ?;";
            stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("user_id");
                int orderId = rs.getInt("order_id");
                int orderlineId = rs.getInt("orderline.id");
                CupCakePiece topping = new CupCakePiece(rs.getInt("toppings.id"), rs.getString("topping"), rs.getDouble("toppings.price"));
                CupCakePiece bottom = new CupCakePiece(rs.getInt("bottoms.id"), rs.getString("bottom"), rs.getDouble("bottoms.price"));
                double price = rs.getDouble("orderline.price");
                int amount = rs.getInt("amount");
                dateTime = rs.getString("orders.date");
                orderlines.add(new OrderLine(userId, orderId, orderlineId, topping, bottom, price, amount));
            }
            order = new Order(id, orderlines, dateTime);
            
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
        return order;
    }
    
    public ArrayList<Order> getUsersOrders(int id){
        ArrayList<Order> orders = new ArrayList();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * "
                    + "FROM orders "
                    + "WHERE user_id = ?;";
            stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                String dateTime = rs.getString("date");
                orders.add(new Order(orderId,getOrder(orderId).getOrder(), dateTime));
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
        return orders;
    }
    
    public ArrayList<Order> getAllOrders(int id){
        ArrayList<Order> orders = new ArrayList();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * "
                    + "FROM orders;";
            stmt = conn.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("id");
                String dateTime = rs.getString("date");
                orders.add(new Order(id,getOrder(orderId).getOrder(), dateTime));
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
        return orders;
    }
    public void insertOrder(ArrayList<CupCake> cart, User user)
    {
        PreparedStatement stmt = null;
        int lastId = 0;
        try
        {
            String sql = "insert into orders (user_id) values (?)";
            stmt = conn.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.first())
            {
                lastId = rs.getInt(1);
            }
            sql = "insert into orderline (topping_id, bottom_id, order_id, price, amount) values (?, ?, ?, ?, ?)";
            stmt = conn.getConnection().prepareStatement(sql);
            for (CupCake c : cart)
            {
                stmt.setInt(1, c.getTopping().getId());
                stmt.setInt(2, c.getBottom().getId());
                stmt.setInt(3, lastId);
                stmt.setDouble(4, c.getPrice());
                stmt.setInt(5, c.getAmount());
                stmt.executeUpdate();
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            if (stmt != null)
            {
                try
                {
                    stmt.close();
                } catch (SQLException ex)
                {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    

}
