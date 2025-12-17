package commerce;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Category> categories = new ArrayList<>(); // list 선언

        Category electronics = new Category("전자제품");
        Category clothes = new Category("의류");
        Category food = new Category("식품");

        categories.add(electronics);
        categories.add(clothes);
        categories.add(food);

        electronics.addProduct(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰",50));
        electronics.addProduct(new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰",30));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북",20));
        electronics.addProduct(new Product("AirPods", 350000, "노이즈 캔슬링 무선 이어폰",40));

        CommerceSystem commerceSystem = new CommerceSystem(categories);
        commerceSystem.start();
    }
}
