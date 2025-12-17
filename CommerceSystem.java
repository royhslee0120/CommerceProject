package commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Category> categories;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            printCategories();

            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }

            if (choice < 1 || choice > categories.size()) {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                continue;
            }

            Category selectedCategory = categories.get(choice - 1);

            startProduct(sc, selectedCategory);
        }
    }

    private void printCategories() {

        System.out.println("[실시간 커머스 플랫폼 메인]");

        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
        System.out.printf("%d. %-9s | %s\n", 0, "종료", "프로그램 종료");
    }

    private void startProduct(Scanner sc, Category category) {
        while (true) {
            printProducts(category);

            int productChoice = sc.nextInt();

            if (productChoice == 0) {
                break;
            }

            List<Product> products = category.getProducts();
            if (productChoice < 1 || productChoice > products.size()) {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                continue;
            }

            Product selectedProduct = products.get(productChoice - 1);
            System.out.println("선택한 상품: " + selectedProduct.toDetailSting());
        }
    }


    private void printProducts(Category category) {
        System.out.println("\n[" + category + " 카테고리]");

        List<Product> products = category.getProducts();

        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.println("0. 뒤로가기");
    }
}
