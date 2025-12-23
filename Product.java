package commerce;

public class Product {

    private String name;
    private int price;
    private String info;
    private int amount;

    public Product(String name, int price, String info, int amount) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.amount = amount;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getInfo() { return info; }
    public int getAmount() { return amount; }

    public boolean hasStock(int qty) {
        return amount >= qty;
    }

    public void decreaseStock(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("수량은 1 이상이어야 합니다.");
        if (!hasStock(qty)) throw new IllegalStateException("재고가 부족합니다.");
        amount -= qty;
    }

    public String toString() {
        return String.format("%-11s | %,10d원 | %s", name, price, info);
    }

    public String toDetailString() { // 오타 수정
        return String.format("%-11s | %,10d원 | %s | 재고: %d개", name, price, info, amount);
    }

    public String toCartString() {
        return String.format("%s | %,d원 | %s", name, price, info);
    }
}
