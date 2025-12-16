package commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private final List<Product> products;

    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();

            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }

            System.out.println("선택한 상품: " + choice);
        }
    }
    private void printMenu() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.printf("%-2d. %-9s | %s\n", 0, "종료", "프로그램 종료");
        System.out.print("상품 선택: ");
    }
}
