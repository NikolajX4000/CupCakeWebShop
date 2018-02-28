package Data;

public class CupCakePiece{

    private int id;
    private String flavor;
    private double price;

    public CupCakePiece(int id, String flavor, double price) {
        this.id = id;
        this.flavor = flavor;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }
}
