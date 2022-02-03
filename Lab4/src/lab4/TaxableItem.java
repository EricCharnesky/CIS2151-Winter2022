
package lab4;

public class TaxableItem extends Item {
    
    private double taxRate;

    public TaxableItem(String name, int quantity, double price, double taxRate) {
        super(name, quantity, price);
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    
    @Override
    public double getTotalPrice(){
        return super.getTotalPrice() + super.getTotalPrice() * taxRate;
    }
    
}
