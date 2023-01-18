/* Joel Goode - CMIS 242/4010 - 6/6/22
 * Create a program to order a snack from.
 * Parent class: Snack Children: FruitSnack (citrus fruit boolean) & SaltySnack (nut snack boolean)
 * Prices:
 * (S) $19.99 (M) $29.99 (L) $39.99
 * FruitSnack added fee of $5.99 for citrus fruit
 * SaltySnack added fee of $4.50 for nut snack
 * Must have method to return and display each class's values
 * OrderSystem class to test functionallity and display:
 * Snack type
 * Size
 * ID
 * Price
 */

public class Snack {

	// Variables.
    private String id;
    private String size;
    private double price;
    private final double PRICE_S = 19.99;
    private final double PRICE_M = 29.99;
    private final double PRICE_L = 39.99;
    
    //Constructor.
    public Snack(String id, String size) {
        this.id = id;
        this.size = size;
    }
    
    // Setter and Getters.
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getSize() {
        return size;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    
    
    // Function to calculate price based on size
    public void calculatePrice() {
        if(size.equals("S")) {
           this.price = PRICE_S;
        }
        else if(size.equals("M")) {
            this.price = PRICE_M;
        }
        else if(size.equals("L")) {
            this.price = PRICE_L;
        }
    }
    
  
    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Size: " + size + "\n";
    }
}