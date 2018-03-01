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
    private int user_id;
    private int order_id;
    private int order_line_id;
    private CupCakePiece topping;
    private CupCakePiece bottom;
    private double price;
    private int amount;

    public OrderLine(String username, int user_id, int order_id, int order_line_id, CupCakePiece topping, CupCakePiece bottom, double price, int amount)
    {
        this.username = username;
        this.user_id = user_id;
        this.order_id = order_id;
        this.order_line_id = order_line_id;
        this.topping = topping;
        this.bottom = bottom;
        this.price = price;
        this.amount = amount;
    }

    public String getUsername()
    {
        return username;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public int getOrder_id()
    {
        return order_id;
    }

    public int getOrder_line_id()
    {
        return order_line_id;
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
        hash = 79 * hash + this.order_line_id;
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
        if (this.order_line_id != other.order_line_id) {
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



