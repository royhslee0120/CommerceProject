package commerce;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("수량은 1 이상이어야 합니다.");
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void addQuantity(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("수량은 1 이상이어야 합니다.");
        this.quantity += qty;
    }

    public int getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
