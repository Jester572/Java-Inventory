public class Products extends Item{
    private int productId;
    public static int productCounter = 0;
    Products(String iName, int iQuantity) {
        super(iName, iQuantity);
        this.productId = productCounter++;
    }

    public int getProductId() {
        return productId;
    }
}
