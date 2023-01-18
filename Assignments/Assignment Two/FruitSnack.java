// Joel Goode - CMIS 242/4010 - 6/6/22

public class FruitSnack extends Snack {

	private boolean citrus;
    private final double CITRUS_PRICE = 5.99;
    
    public FruitSnack(String id, String size, boolean citrus) {
        super(id, size);
        this.citrus = citrus;
    }
    
    public void setCitrus(boolean citrus) {
        this.citrus = citrus;
    }
    public boolean getCitrus() {
        return citrus;
    }
    
    /**
     * Calculate the updated price based on citrus value
     */
    public void additional() {
        if(citrus) {
            super.setPrice(super.getPrice() + CITRUS_PRICE);
        }
    }
    
    /**
     * String representation of class
     * @return values of each fields
     */
    @Override
    public String toString() {
        return "\nFruit Snack:\n" +
               super.toString() +
               "Additional Citrus: " + String.valueOf(citrus) + "\n" +
               "Price: $" + String.format("%.2f", super.getPrice());
    }
    
}