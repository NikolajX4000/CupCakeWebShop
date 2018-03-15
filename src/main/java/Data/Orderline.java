package Data;

import java.util.Objects;

/**
 * @author Daniel Lindholm, Jacob Borg, Nikolaj Thorsen Nielsen, Stephan Marcus Duelund Djurhuus
 */
public class Orderline {

    private int userId;
    private int orderId;
    private int orderlineId;
    private CupCake cupCake;

    /**
     *
     * @param userId the id of the customer
     * @param orderId the id of the order
     * @param orderlineId the orderlines id
     * @param topping the topping of the cupcake
     * @param bottom the bottom of the cupcake
     * @param price the price per cupcake
     * @param amount the amount of cupcakes
     */
    public Orderline(int userId, int orderId, int orderlineId, CupCakePiece topping, CupCakePiece bottom, double price, int amount) {
        this.userId = userId;
        this.orderId = orderId;
        this.orderlineId = orderlineId;
        this.cupCake = new CupCake(bottom, topping, amount);
    }

    /**
     *
     * @return the id of the customer
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @return the id of the order
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     *
     * @return the orderlines id
     */
    public int getOrderlineId() {
        return orderlineId;
    }

    /**
     *
     * @return the cupcake
     */
    public CupCake getCupCake() {
        return cupCake;
    }

    @Override
    public String toString() {
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
        final Orderline other = (Orderline) obj;
        if (this.orderlineId != other.orderlineId) {
            return false;
        }
        if (!Objects.equals(this.cupCake, other.cupCake)) {
            return false;
        }
        return true;
    }

}
