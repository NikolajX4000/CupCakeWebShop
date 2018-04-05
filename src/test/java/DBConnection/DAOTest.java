/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import Data.CupCake;
import Data.CupCakePiece;
import Data.Order;
import Data.User;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stephan
 */
public class DAOTest {
    
    public DAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUser method, of class DAO.
     */
    @Test
    public void testGetUser_String() {
        System.out.println("getUser");
        String un = "JUnit_testUser";
        DAO instance = new DAO();
        String expResult = "JUnit_testUser";
        User result = instance.getUser(un);
        assertEquals(expResult, result.getUsername());
    }

    /**
     * Test of getUser method, of class DAO.
     */
    @Test
    public void testGetUser_int() {
        System.out.println("getUser");
        int id = 51;
        DAO instance = new DAO();
        String expResult = "JUnit_testUser";
        User result = instance.getUser(id);
        assertEquals(expResult, result.getUsername());
    }

    /**
     * Test of getUsers method, of class DAO.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        DAO instance = new DAO();
        String expResult = "JUnit_testUser";
        ArrayList<User> result = instance.getUsers();
        assertEquals(expResult, result.get(36).getUsername());
    }

    /**
     * Test of createCustomer method, of class DAO.
     */
    @Test
    public void testCreateCustomer() {
        System.out.println("createCustomer");
        String username = "JUnit_testUser";
        String password1 = "pw";
        String password2 = "pw";
        DAO instance = new DAO();
        boolean expResult = true;
        boolean result = instance.createCustomer(username, password1, password2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createCustomer method, of class DAO.
     */
    @Test
    public void testCreateCustomerDistinctPasswords() {
        System.out.println("createCustomer DistinctPasswords");
        String username = "JUnit_testUser";
        String password1 = "pw";
        String password2 = "err_pw";
        DAO instance = new DAO();
        boolean expResult = false;
        boolean result = instance.createCustomer(username, password1, password2);
        assertEquals(expResult, result);
    }

    /**
     * Test of createAdmin method, of class DAO.
     */
    @Test
    public void testCreateAdmin() {
        System.out.println("createAdmin");
        String username = "JUnit_testAdmin";
        String password1 = "pw";
        String password2 = "pw";
        DAO instance = new DAO();
        boolean expResult = true;
        boolean result = instance.createAdmin(username, password1, password2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createAdmin method, of class DAO.
     */
    @Test
    public void testCreateAdminDistinctPasswords() {
        System.out.println("createAdmin DistinctPasswords");
        String username = "JUnit_testAdmin";
        String password1 = "pw";
        String password2 = "err_pw";
        DAO instance = new DAO();
        boolean expResult = false;
        boolean result = instance.createAdmin(username, password1, password2);
        assertEquals(expResult, result);
    }

    /**
     * Test of getToppings method, of class DAO.
     */
    @Test
    public void testGetToppings() {
        System.out.println("getToppings");
        DAO instance = new DAO();
        String expResult = "Chocolate";
        ArrayList<CupCakePiece> result = instance.getToppings();
        assertEquals(expResult, result.get(0).getFlavor());
    }

    /**
     * Test of getBottoms method, of class DAO.
     */
    @Test
    public void testGetBottoms() {
        System.out.println("getBottoms");
        DAO instance = new DAO();
        String expResult = "Chocolate";
        ArrayList<CupCakePiece> result = instance.getBottoms();
        assertEquals(expResult, result.get(0).getFlavor());
    }

    /**
     * Test of getTopping method, of class DAO.
     */
    @Test
    public void testGetTopping() {
        System.out.println("getTopping");
        int id = 1;
        DAO instance = new DAO();
        String expResult = "Chocolate";
        CupCakePiece result = instance.getTopping(id);
        assertEquals(expResult, result.getFlavor());
    }

    /**
     * Test of getBottom method, of class DAO.
     */
    @Test
    public void testGetBottom() {
        System.out.println("getBottom");
        int id = 1;
        DAO instance = new DAO();
        String expResult = "Chocolate";
        CupCakePiece result = instance.getBottom(id);
        assertEquals(expResult, result.getFlavor());
    }

    /**
     * Test of login method, of class DAO.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "JUnit_testUser";
        String password = "pw";
        DAO instance = new DAO();
        String expResult = "JUnit_testUser";
        User result = instance.login(username, password);
        assertEquals(expResult, result.getUsername());
    }

    /**
     * Test of getOrder method, of class DAO.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        int id = 1;
        DAO instance = new DAO();
        int expResult = 1;
        Order result = instance.getOrder(id);
        assertEquals(expResult, result.getId());
    }

    /**
     * Test of getUsersOrders method, of class DAO.
     */
    @Test
    public void testGetUsersOrders() {
        System.out.println("getUsersOrders");
        int id = 51;
        DAO instance = new DAO();
        int expResult = 37;
        ArrayList<Order> result = instance.getUsersOrders(id);
        assertEquals(expResult, result.get(0).getId());

    }

    /**
     * Test of getAllOrders method, of class DAO.
     */
    @Test
    public void testGetAllOrders() {
        System.out.println("getAllOrders");
        DAO instance = new DAO();
        int expResult = 11;
        ArrayList<Order> result = instance.getAllOrders();
        assertEquals(expResult, result.get(10).getId());
    }

    /**
     * Test of insertOrder method, of class DAO.
     */
    /*  @Test
    public void testInsertOrder() {
        System.out.println("insertOrder");
        DAO instance = new DAO();
        ArrayList<CupCake> cart = new ArrayList();
        CupCakePiece btm = instance.getBottom(1);
        CupCakePiece tpn = instance.getTopping(1);
        cart.add( new CupCake(btm, tpn, 1) );
        User user = instance.login("JUnit_testUser", "pw");
        int expResult = 48; // --> increments for every test run
        int result = instance.insertOrder(cart, user);
        assertEquals(expResult, result);
    } */

    /**
     * Test of addTopping method, of class DAO.
     */
    /* @Test
    public void testAddTopping() {
        System.out.println("addTopping");
        String flavor = "JUnit_toppingFlavor";
        double price = 1.2;
        DAO instance = new DAO();
        boolean expResult = true;
        boolean result = instance.addTopping(flavor, price);
        assertEquals(expResult, result);
    } */

    /**
     * Test of addBottom method, of class DAO.
     */
    /* @Test
    public void testAddBottom() {
        System.out.println("addBottom");
        String flavor = "JUnit_bottomFlavor";
        double price = 2.1;
        DAO instance = new DAO();
        boolean expResult = true;
        boolean result = instance.addBottom(flavor, price);
        assertEquals(expResult, result);
    } */

    /**
     * Test of changeOrderlineAmount method, of class DAO.
     */
    @Test
    public void testChangeOrderlineAmount() {
        System.out.println("changeOrderlineAmount");
        int id = 1;
        int amount = 10;
        DAO instance = new DAO();
        boolean result = instance.changeOrderlineAmount(id, amount);
        assertTrue(result);
    }

    /**
     * Test of getUserById method, of class DAO.
     */
    @Test
    public void testGetUserById() {
        System.out.println("getUserById");
        int id = 51;
        DAO instance = new DAO();
        String expResult = "JUnit_testUser";
        String result = instance.getUserById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of deposit method, of class DAO.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        int id = 51;
        double value = 1.1;
        DAO instance = new DAO();
        User user = instance.getUser("JUnit_testUser");
        double expResult = user.getBalance() + value;
        double result = instance.deposit(id, value);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of withdrawal method, of class DAO.
     */
    @Test
    public void testWithdrawal() {
        System.out.println("withdrawal");
        int id = 51;
        double value = 2.0;
        DAO instance = new DAO();
        boolean result = instance.withdrawal(id, value);
        assertTrue(result);
    }

    /**
     * Test of updateOrderLine method, of class DAO.
     */
    /* 
    Manglende metode 'getOrderlineById()' i dao
    
    @Test
    public void testUpdateOrderLine() {
        System.out.println("updateOrderLine");
        int orderlineId = 1;
        int amount = 10;
        DAO instance = new DAO();
        instance.updateOrderLine(orderlineId, amount);
    } */
    
}
