// Joel Goode - CMIS 242/4010 - 6/6/22

public class SaltySnack extends Snack {

	private boolean nuts;
    private final double NUT_PRICE = 4.50;
    
    public SaltySnack(String id, String size, boolean nuts) {
        super(id, size);
        this.nuts = nuts;
    }
    
    
     // Calculate the updated price based on nut value
    public void additional() {
        if(nuts) {
            super.setPrice(super.getPrice() + NUT_PRICE);
        }
    }
    
    @Override
    public String toString() {
        return "\nSalty Snack:\n" +
               super.toString() +
               "Additional Nuts: " + String.valueOf(nuts) + "\n" +
               "Price: $" + String.format("%.2f", super.getPrice());
    }
}