package Data;

import java.util.ArrayList;

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
            totalPrice += ol.getCupCake().getPrice();
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
