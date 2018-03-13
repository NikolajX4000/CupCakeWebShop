package Data;

/**
 *
 * @author super
 */
public class CupCakePiece {

    private int id;
    private String flavor;
    private double price;

    /**
     *
     * @param id the id of the cupcakepiece
     * @param flavor the flavor of the cupcakepiece
     * @param price the price of the cupcakepiece
     */
    public CupCakePiece(int id, String flavor, double price) {
        this.id = id;
        this.flavor = flavor;
        this.price = price;
    }

    /**
     *
     * @return the id of the cupcakepiece
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return the the flavor of the cupcakepiece
     */
    public String getFlavor() {
        return flavor;
    }

    /**
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
