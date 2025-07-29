package case_study.view;

import case_study.controller.RealEstateController;
import case_study.entity.RealEstate;
import common.InputExceptions;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class ViewRealEstate {
    static Scanner scanner = new Scanner(System.in);
    RealEstateController controller = new RealEstateController();

    public void mainMenu() {
        System.out.println("======Menu======");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
        int choose = InputExceptions.inputInterger();
        switch (choose) {
            case 1 -> menuAdmin();
            case 2 -> menuCustomer();
            case 0 -> {
                System.out.println("Tạm biệt!");
            }
            default -> System.out.println("Vui lòng nhập lại!");
        }
    }

    public void menuAdmin() {
        System.out.println("====Admin====");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Xoá theo mã");
        System.out.println("4. Sửa theo mã");
        System.out.println("5. Tìm kiếm theo mã");
        System.out.println("6. Tìm kiếm theo tên");
        System.out.println("0. quay lại menu chính");
        System.out.print("Chọn chức năng: ");
        int choose = InputExceptions.inputInterger();
        while (true) {
            switch (choose) {
                case 1 -> displayList();
                case 2 -> add();
                case 3 -> delete();
                case 4 -> update();
                case 5 -> searchByCode();
                case 6 -> searchByName();
                case 0 -> {
                    mainMenu();
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }

    public void menuCustomer() {
        System.out.println("====Customer====");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm vào giỏ hàng bằng mã");
        System.out.println("3. Xem giỏ hàng");
        System.out.println("4. Liên hệ người bán");
        System.out.println("5. Xem thông báo");
        System.out.println("0. quay lại menu chính");
        while (true) {
            System.out.print("Chọn chức năng: ");
            int choose = InputExceptions.inputInterger();
            switch (choose) {
                case 1 -> displayList();
                case 2 -> add();
                case 3 -> MenuCart();
                case 4 -> contact();
                case 5 -> displayNotification();
                case 0 -> mainMenu();
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }

    public void MenuCart() {
        System.out.println("1. Thêm vào giỏ theo mã");
        System.out.println("2. Xoá khỏi giỏ theo mã");
        System.out.println("0. Quay lại");
        int choose = InputExceptions.inputInterger();
        while (true) {
            switch (choose) {
                case 1 -> showCart();
                case 2 -> deleteFromCart();
                case 3 -> updateFromCart();
                case 4 -> addToCart();
                case 0 -> menuCustomer();
                default -> System.out.println("Vui lòng nhập lại!");
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
        boolean isSold = scanner.hasNext();
        return new RealEstate(code, name, type, location, area, price, isSold);

    }
}
