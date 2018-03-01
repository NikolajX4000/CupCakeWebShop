package Data;

import java.util.Objects;

public class CupCake {

    private CupCakePiece bottom;
    private CupCakePiece topping;
    private double price;
    private int amount;

    public CupCake(CupCakePiece bottom, CupCakePiece topping, int amount) {
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
        price = this.bottom.getPrice() + this.topping.getPrice();
    }

    public CupCakePiece getBottom() {
        return bottom;
    }

    public CupCakePiece getTopping() {
        return topping;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount()
    {
        return amount;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.bottom);
        hash = 61 * hash + Objects.hashCode(this.topping);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final CupCake other = (CupCake) obj;
        if (!Objects.equals(this.bottom, other.bottom))
        {
            return false;
        }
        if (!Objects.equals(this.topping, other.topping))
        {
            return false;
        }
        return true;
    }
    
    

    
    
    public void addAmount(int amount)
    {
        this.amount += amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return "CupCake{" + "bottom=" + bottom + ", topping=" + topping + ", price=" + price + ", amount=" + amount + '}';
    }
    
}
