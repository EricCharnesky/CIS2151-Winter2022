
package lab6;

public class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public boolean purchase(int quantityToPurchase){
        if ( quantityToPurchase > quantity ){
            return false;
        }
        quantity -= quantityToPurchase;
        return true;
    }
    
    @Override
    public String toString()
    {
        return name + " $" + price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    
    
}
