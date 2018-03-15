package Data;

import java.util.ArrayList;

/**
 * @author Daniel Lindholm, Jacob Borg, Nikolaj Thorsen Nielsen, Stephan Marcus Duelund Djurhuus
 */
public class Order {

    private int id;
    private ArrayList<Orderline> orderlines;
    private double totalPrice;
    private String dateTime;

    /**
     * Constructor
     * 
     * @param id the orders id, should be not null
     * @param orderlines the orderlines in the orderlines, should be not null
     * @param date the date of placing the orderlines, should be not null
     */
    public Order(int id, ArrayList<Orderline> orderlines, String date) {
        this.id = id;
        this.orderlines = orderlines;
        dateTime = date;
        setPrice();
    }

    private void setPrice() {
        for (Orderline ol : orderlines) {
            totalPrice += ol.getCupCake().getPrice();
        }
    }

    /**
     * Returns the id.
     * 
     * @return the orders id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the orderlines
     * 
     * @return a list of the orderlines
     */
    public ArrayList<Orderline> getOrderlines() {
        return orderlines;
    }

    /**
     * Returns the price
     * 
     * @return the total price of the orderlines
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Returns the time
     * 
     * @return the time of placing the orderlines
     */
    public String getDateTime() {
        return dateTime;
    }

}
