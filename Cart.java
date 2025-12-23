package commerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addProduct(Product product, int qty) { // 동일 상품이면 수량 증가, 아니면 새 항목 추가
        for (CartItem item : items) {
            if (item.getProduct() == product) { // 같은 객체면 같은 상품
                item.addQuantity(qty);
                return;
            }
        }
        items.add(new CartItem(product, qty));
    }

    public int getTotalAmount() {
        int sum = 0;
        for (CartItem item : items) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public void clear() {
        items.clear();
    }
}
