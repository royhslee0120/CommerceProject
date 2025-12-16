package commerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[실시간 커머스 플랫폼 - 전자제품]");

        List<Product> products = new ArrayList<>(); // list 선언

        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰",50));
        products.add(new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰",30));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북",20));
        products.add(new Product("AirPods", 350000, "노이즈 캔슬링 무선 이어폰",40));

        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.printf("%-2d. %-9s | %s\n", 0, "종료", "프로그램 종료");

        int list = sc.nextInt();
    }
}
