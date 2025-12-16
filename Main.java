package commerce;

public class Main {

    public static void main(String[] args) {

        System.out.println("[실시간 커머스 플랫폼 - 전자제품]");

        Product p1 = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰",50);
        Product p2 = new Product("iPhone 17", 1350000, "Apple의 최신 스마트폰",30);
        Product p3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북",20);
        Product p4 = new Product("AirPods", 350000, "노이즈 캔슬링 무선 이어폰",40);

        System.out.println("1. " + p1);
        System.out.println("2. " + p2);
        System.out.println("3. " + p3);
        System.out.println("4. " + p4);

    }
}
