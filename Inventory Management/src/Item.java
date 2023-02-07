public class Item {
    int quantity;
    String name;

    Item (String iName, int iQuantity) {
        name = iName;
        quantity = iQuantity;
    }
    void addItem () {

    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
