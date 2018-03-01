/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Objects;

/**
 *
 * @author Stephan
 */
public class OrderLine
{
    private int userId;
    private int orderId;
    private int orderlineId;
    private CupCake cupCake;


    public OrderLine(int userId, int orderId, int orderlineId, CupCakePiece topping, CupCakePiece bottom, double price, int amount)
    {
        this.userId = userId;
        this.orderId = orderId;
        this.orderlineId = orderlineId;
        this.cupCake = new CupCake(topping, bottom, amount);
    }

    public int getUserId()
    {
        return userId;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public int getOrderlineId()
    {
        return orderlineId;
    }

    public CupCake getCupCake() {
        return cupCake;
    }

    @Override
    public String toString()
    {
        return "OrderLine" + "topping=" + cupCake.getTopping() + ", bottom=" + cupCake.getBottom() + ", price=" + cupCake.getPrice() + ", amount=" + cupCake.getAmount();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.orderlineId;
        hash = 67 * hash + Objects.hashCode(this.cupCake);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderLine other = (OrderLine) obj;
        if (this.orderlineId != other.orderlineId) {
            return false;
        }
        if (!Objects.equals(this.cupCake, other.cupCake)) {
            return false;
        }
        return true;
    }

    
}



