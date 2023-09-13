package dataProvider;

public class Product {

    private int product_id;
    private int quantity;

    public Product(int product_id, int quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}
