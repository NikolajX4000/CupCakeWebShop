/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author Stephan
 */
public class Order {

    int id;
    ArrayList<OrderLine> order;
    double totalPrice;
    String dateTime;

    /**
     *
     * @param id the orders id
     * @param orderlines the orderlines in the order
     * @param date the date of placing the order
     */
    public Order(int id, ArrayList<OrderLine> orderlines, String date) {
        this.id = id;
        this.order = orderlines;
        dateTime = date;
        setPrice();
    }

    private void setPrice() {
        for (OrderLine ol : order) {
            totalPrice += ol.getCupCake().getPrice();
        }
    }

    /**
     *
     * @return the orders id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return a list of the orderlines
     */
    public ArrayList<OrderLine> getOrder() {
        return order;
    }

    /**
     *
     * @return the total price of the orderlines
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     *
     * @return the time of placing the order
     */
    public String getDateTime() {
        return dateTime;
    }

}
