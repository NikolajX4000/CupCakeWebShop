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
    ArrayList<OrderLine> order;
    double totalPrice;

    public Order(ArrayList<OrderLine> order) {
        this.order = order;
        setPrice();
    }
    
    private void setPrice() {
        for (OrderLine ol : order) {
            totalPrice += ol.getPrice();
        }
    }

    public ArrayList<OrderLine> getOrder() {
        return order;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
}
