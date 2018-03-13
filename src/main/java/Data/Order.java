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

    private int id;
    private ArrayList<Orderline> orderlines;
    private double totalPrice;
    private String dateTime;

    /**
     *
     * @param id the orders id
     * @param orderlines the orderlines in the orderlines
     * @param date the date of placing the orderlines
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
    public ArrayList<Orderline> getOrderlines() {
        return orderlines;
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
     * @return the time of placing the orderlines
     */
    public String getDateTime() {
        return dateTime;
    }

}
