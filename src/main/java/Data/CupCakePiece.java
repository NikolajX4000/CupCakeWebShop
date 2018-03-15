package Data;

/**
 * @author Daniel Lindholm, Jacob Borg, Nikolaj Thorsen Nielsen, Stephan Marcus Duelund Djurhuus
 */
public class CupCakePiece {

    private int id;
    private String flavor;
    private double price;

    /**
     * Constructer.
     * 
     * @param id the id of the cupcakepiece, should be not null
     * @param flavor the flavor of the cupcakepiece, should be not null
     * @param price the price of the cupcakepiece, should be not null
     */
    public CupCakePiece(int id, String flavor, double price) {
        this.id = id;
        this.flavor = flavor;
        this.price = price;
    }

    /**
     * Returns the id.
     * 
     * @return the id of the cupcakepiece
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the flavor.
     * 
     * @return the the flavor of the cupcakepiece
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Returns the price.
     * 
     * @return the price of the cupcakepiece
     */
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "CupCakePiece{" + "id=" + id + ", flavor=" + flavor + ", price=" + price + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
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
        final CupCakePiece other = (CupCakePiece) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
