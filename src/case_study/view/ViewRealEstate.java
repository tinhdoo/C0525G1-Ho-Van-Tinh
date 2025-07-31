package case_study.view;

import case_study.controller.RealEstateController;
import case_study.entity.RealEstate;
import common.InputExceptions;
import java.util.List;
import java.util.Scanner;

public class ViewRealEstate {
    static Scanner scanner = new Scanner(System.in);
    RealEstateController controller = new RealEstateController();

    public void mainMenu() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║              MENU CHÍNH              ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1. Quản trị viên (Admin)             ║");
            System.out.println("║ 2. Khách hàng (Customer)             ║");
            System.out.println("║ 0. Thoát chương trình                ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            int choose = InputExceptions.inputInterger();
            switch (choose) {
                case 1 -> menuAdmin();
                case 2 -> menuCustomer();
                case 0 -> {
                    System.out.println("Đã thoát chương trình. Hẹn gặp lại!");
                    return;
                }
                default -> System.out.println("⚠️  Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }

    public void menuAdmin() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║              MENU ADMIN              ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1. Hiển thị danh sách                ║");
            System.out.println("║ 2. Thêm mới                          ║");
            System.out.println("║ 3. Xoá theo mã                       ║");
            System.out.println("║ 4. Sửa theo mã                       ║");
            System.out.println("║ 5. Tìm kiếm theo mã                  ║");
            System.out.println("║ 6. Tìm kiếm theo tên                 ║");
            System.out.println("║ 0. Quay lại menu chính               ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            int choose = InputExceptions.inputInterger();
            switch (choose) {
                case 1 -> displayList();
                case 2 -> add();
                case 3 -> delete();
                case 4 -> update();
                case 5 -> searchByCode();
                case 6 -> searchByName();
                case 0 -> {
                    return;
                }
                default -> System.out.println("⚠️  Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }
    public void menuCustomer() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║           MENU KHÁCH HÀNG            ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1. Hiển thị danh sách                ║");
            System.out.println("║ 2. Thêm vào giỏ hàng (theo mã)       ║");
            System.out.println("║ 3. Xem giỏ hàng                      ║");
            System.out.println("║ 4. Liên hệ người bán                 ║");
            System.out.println("║ 5. Xem thông báo                     ║");
            System.out.println("║ 0. Quay lại menu chính               ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            int choose = InputExceptions.inputInterger();
            switch (choose) {
                case 1 -> displayList();
                case 2 -> add();
                case 3 -> menuCart();
                case 4 -> contact();
                case 5 -> displayNotification();
                case 0 -> {
                    return;
                }
                default -> System.out.println("⚠️  Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }


    public void menuCart() {
        while (true) {
            System.out.println("\n========= GIỎ HÀNG =========");
            System.out.println("1. ➕  Thêm vào giỏ (theo mã)");
            System.out.println("2. ❌  Xoá khỏi giỏ (theo mã)");
            System.out.println("3. 📝  Cập nhật sản phẩm trong giỏ");
            System.out.println("4. 📦  Hiển thị giỏ hàng");
            System.out.println("0. ⬅️  Quay lại");
            System.out.print("👉 Nhập lựa chọn của bạn: ");

            int choose = InputExceptions.inputInterger();
            switch (choose) {
                case 1 -> addToCart();
                case 2 -> deleteFromCart();
                case 3 -> updateFromCart();
                case 4 -> showCart();
                case 0 -> {
                    return;
                }
                default -> System.out.println("⚠️  Lựa chọn không hợp lệ. Vui lòng thử lại!");
            }
        }
    }

    private void addToCart() {
    }

    private void updateFromCart() {
    }

    private void deleteFromCart() {
    }

    private void showCart() {
    }

    public void displayNotification() {
    }

    public void contact() {
    }


    public void add() {
        RealEstate realEstate = input();
        controller.add(realEstate);
    }

    public void delete() {
        System.out.println("Nhập mã cần xoá: ");
        int code = InputExceptions.inputInterger();
        controller.delete(code);
    }

    public void update() {
    }

    public void searchByName() {
    }

    public void searchByCode() {
    }

    private void displayList() {
        controller.findAll();
    }

    private void displayRealEstates(List<RealEstate> realEstates) {
        System.out.println(realEstates);
    }

    public RealEstate input() {
        System.out.println("Nhập mã: ");
        int code = InputExceptions.inputInterger();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập loại: ");
        String type = scanner.nextLine();
        System.out.println("Nhập vị trí: ");
        String location = scanner.nextLine();
        System.out.println("Nhập diện tích: ");
        double area = scanner.nextDouble();
        System.out.println("Nhập giá: ");
        double price = scanner.nextDouble();
        System.out.println("Tình trạng: ");
        boolean isSold = scanner.nextBoolean();
        return new RealEstate(code, name, type, location, area, price, isSold);

    }

}
