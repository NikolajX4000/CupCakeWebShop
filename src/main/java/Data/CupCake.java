package Data;

import java.util.Objects;

/**
 * @author Daniel Lindholm, Jacob Borg, Nikolaj Thorsen Nielsen, Stephan Marcus Duelund Djurhuus
 */
public class CupCake {

    private CupCakePiece bottom;
    private CupCakePiece topping;
    private double price;
    private int amount;

    /**
     *
     * @param bottom the bottom of the cupcake
     * @param topping the topping of the cupcake
     * @param amount the amount of cupcakes
     */
    public CupCake(CupCakePiece bottom, CupCakePiece topping, int amount) {
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
        price = this.bottom.getPrice() + this.topping.getPrice();
    }

    /**
     *
     * @return the bottom of the cupcake
     */
    public CupCakePiece getBottom() {
        return bottom;
    }

    /**
     *
     * @return the topping of the cupcake
     */
    public CupCakePiece getTopping() {
        return topping;
    }

    /**
     *
     * @return the price of the cupcake
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return the amount of cupcakes
     */
    public int getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.bottom);
        hash = 61 * hash + Objects.hashCode(this.topping);
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
        final CupCake other = (CupCake) obj;
        if (!Objects.equals(this.bottom, other.bottom)) {
            return false;
        }
        if (!Objects.equals(this.topping, other.topping)) {
            return false;
        }
        return true;
    }

    /**
     * adds to the amount of cupcakes
     *
     * @param amount the amount to be added
     */
    public void addAmount(int amount) {
        this.amount += amount;
    }

    /**
     * set the amount of cupcake
     *
     * @param amount the amount to be set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CupCake{" + "bottom=" + bottom + ", topping=" + topping + ", price=" + price + ", amount=" + amount + '}';
    }

}
