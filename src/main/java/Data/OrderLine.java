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
    private String username;
    private int userId;
    private int orderId;
    private int orderlineId;
    private CupCakePiece topping;
    private CupCakePiece bottom;
    private double price;
    private int amount;
    private String dateTime;

    public OrderLine(String username, int userId, int orderId, int orderlineId, CupCakePiece topping, CupCakePiece bottom, double price, int amount, String dateTime)
    {
        this.username = username;
        this.userId = userId;
        this.orderId = orderId;
        this.orderlineId = orderlineId;
        this.topping = topping;
        this.bottom = bottom;
        this.price = price;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public String getUsername()
    {
        return username;
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

    public CupCakePiece getTopping()
    {
        return topping;
    }

    public CupCakePiece getBottom()
    {
        return bottom;
    }

    public double getPrice()
    {
        return price;
    }

    public int getAmount()
    {
        return amount;
    }

    @Override
    public String toString()
    {
        return "OrderLine" + "topping=" + topping + ", bottom=" + bottom + ", price=" + price + ", amount=" + amount;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 79 * hash + this.orderlineId;
        hash = 79 * hash + Objects.hashCode(this.topping);
        hash = 79 * hash + Objects.hashCode(this.bottom);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
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
        if (!Objects.equals(this.topping, other.topping)) {
            return false;
        }
        if (!Objects.equals(this.bottom, other.bottom)) {
            return false;
        }
        return true;
    }
    
}



