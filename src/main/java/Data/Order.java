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

    public Order(int id, ArrayList<OrderLine> order, String date) {
        this.id = id;
        this.order = order;
        dateTime = date;
        setPrice();
    }

    private void setPrice() {
        for (OrderLine ol : order) {
            totalPrice += ol.getPrice();
        }
    }

    public int getId() {
        return id;
    }

    public ArrayList<OrderLine> getOrder() {
        return order;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getDateTime() {
        return dateTime;
    }

}
