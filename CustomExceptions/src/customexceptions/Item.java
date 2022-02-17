package customexceptions;

public class Item {

    private String name;
    private double price;
    private int quantityOnHand;

    public Item(String name, double price, int quantityOnHand) {
        this.name = name;
        setPrice(price);
        setQuantityOnHand(quantityOnHand);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws NegativeArgumentException {
        if (price < 0) {
            throw new NegativeArgumentException("Price can not be negative");
        }
        this.price = price;

    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) throws NegativeArgumentException {
        if (quantityOnHand < 0) {
            throw new NegativeArgumentException("Quantity on hand can not be negative");
        }
        this.quantityOnHand = quantityOnHand;
    }

}
