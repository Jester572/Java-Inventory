//child class
public class Products extends Item{
    private int productId;
    public static int productCounter = 0;
    Products(String iName, int iQuantity) {
        super(iName, iQuantity);
        this.productId = productCounter++;
    }

    //getters
    public int getProductId() {
        return productId;
    }
}
