package commerce;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("[실시간 커머스 플랫폼 - 전자제품]");

        List<Product> products = new ArrayList<>(); // list 선언

        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰",50));
        products.add(new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰",30));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북",20));
        products.add(new Product("AirPods", 350000, "노이즈 캔슬링 무선 이어폰",40));

        CommerceSystem commerceSystem = new CommerceSystem(products);
        commerceSystem.start();
    }
}
