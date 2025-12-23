package commerce;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CommerceSystem {

    private List<Category> categories;
    private final Cart cart = new Cart();

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                printCategories();

                int choice = sc.nextInt();

                if (choice == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                }

                if ((choice == 4 || choice == 5) && cart.isEmpty()) {
                    throw new IllegalStateException("장바구니가 비어있어 주문 관리를 이용할 수 없습니다.");
                }

                if (choice == 4) { // 장바구니 확인/주문
                    startOrder(sc);
                    continue;
                }

                if (choice == 5) { // 주문 취소(장바구니 비우기)
                    cancelOrder();
                    continue;
                }

                if (choice < 1 || choice > categories.size()) {
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    continue;
                }

                Category selectedCategory = categories.get(choice - 1);

                startProduct(sc, selectedCategory);

            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해주세요."); // 숫자 아닌 값 입력했을 때
                sc.nextLine(); // 버퍼 비우기
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
                sc.nextLine();

            }
        }
    }

    private void printCategories() {

        System.out.println("[실시간 커머스 플랫폼 메인]");

        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i));
        }
        System.out.printf("%d. %-9s | %s\n", 0, "종료", "프로그램 종료");

        if (!cart.isEmpty()) {
            System.out.println();
            System.out.println("[ 주문 관리 ]");
            System.out.printf("%d. %-10s | %s\n", 4, "장바구니 확인", "장바구니를 확인 후 주문합니다."); // 콘솔에서 같은 숫자로 입력시 너무 다른위치로 나와서 수정
            System.out.printf("%d. %-11s | %s\n", 5, "주문 취소", "진행중인 주문을 취소합니다.");
        }
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
            System.out.println("선택한 상품: " + selectedProduct.toDetailString()); // 오타 수정

            askAddToCart(sc, selectedProduct);
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

    private void askAddToCart(Scanner sc, Product product) {
        System.out.println();
        System.out.println("\"" + product.toCartString() + "\"");
        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        int input = sc.nextInt();

        if (input == 2) {
            System.out.println("장바구니 추가가 취소되었습니다.");
            return;
        }

        if (input != 1) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        int qty = 1;

        if (!product.hasStock(qty)) { // 재고 확인
            System.out.println("재고가 부족하여 장바구니에 담을 수 없습니다.");
            return;
        }

        cart.addProduct(product, qty);
        System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
    }

    private void startOrder(Scanner sc) { // 주문(장바구니 확인/총액/확정)
        System.out.println();
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        printCart();

        System.out.println();
        System.out.println("1. 주문 확정      2. 메인으로 돌아가기");

        int input = sc.nextInt();
        if (input == 2) return;
        if (input != 1) throw new IllegalArgumentException("잘못된 입력입니다.");

        confirmOrder(); // 주문 확정
    }

    private void printCart() {
        System.out.println("[ 장바구니 내역 ]");

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            System.out.printf("%s | %,d원 | %s | 수량: %d개\n",
                    p.getName(), p.getPrice(), p.getInfo(), item.getQuantity());
        }

        System.out.println();
        System.out.println("[ 총 주문 금액 ]");
        System.out.printf("%,d원\n", cart.getTotalAmount());
    }

    private void confirmOrder() {
        // 1) 재고 최종 검증
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

            if (!p.hasStock(qty)) {
                throw new IllegalStateException(
                        p.getName() + " 재고가 부족하여 주문을 완료할 수 없습니다. (요청: " + qty + ", 남은 재고: " + p.getAmount() + ")"
                );
            }
        }

        // 2) 재고 차감 + 메시지 출력
        int total = cart.getTotalAmount();
        System.out.printf("주문이 완료되었습니다! 총 금액: %,d원\n", total);

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            int before = p.getAmount();
            int qty = item.getQuantity();

            p.decreaseStock(qty);
            int after = p.getAmount();

            System.out.printf("%s 재고가 %d개 → %d개로 업데이트되었습니다.\n", p.getName(), before, after);
        }

        // 3) 장바구니 초기화
        cart.clear();
    }

    private void cancelOrder() {
        cart.clear();
        System.out.println("진행중인 주문(장바구니)이 취소되었습니다.");
    }
}
