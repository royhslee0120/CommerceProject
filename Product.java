package commerce;

public class Product {

    String name;
    int price;
    String info;
    int amount;

    public Product(String name, int price, String info, int amount) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return String.format("%-11s | %,10d원 | %s", name, price, info);
    }

    public String toDetailSting() {
        return String.format("%-11s | %,10d원 | %s | 재고: %d개", name, price, info, amount);
    }

}
