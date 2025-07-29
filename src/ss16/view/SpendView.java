package ss16.view;

import common.IdNotFoundException;
import common.InputExceptions;
import common.UniqueIdException;
import ss16.controller.SpendController;
import ss16.entity.Spend;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SpendView {
    private Scanner scanner = new Scanner(System.in);
    private SpendController controller = new SpendController();

    public void menuSpend() {
        while (true) {
            System.out.println("MENU");
            System.out.println("1. Danh sách chi tiêu");
            System.out.println("2. Thêm chi tiêu");
            System.out.println("3. Xoá chi tiêu");
            System.out.println("4. Sửa chi tiêu");
            System.out.println("5. Tìm kiếm theo mã");
            System.out.println("6. Tìm kiếm gần đúng theo tên");
            System.out.println("7. Sắp xếp theo tên tăng dần");
            System.out.println("8. Sắp xếp theo số tiền chi giảm dần");
            System.out.println("0. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            int choose = InputExceptions.inputInterger();
            switch (choose) {
<<<<<<< HEAD
                case 1 -> getAll();
=======
                case 1 -> findAll();
>>>>>>> save-detached-work
                case 2 -> add();
                case 3 -> delete();
                case 4 -> update();
                case 5 -> searchByCode();
                case 6 -> searchByName();
                case 7 -> sortByNameAsc();
                case 8 -> sortByAmountThenName();
                case 0 -> {
                    System.out.println("Tạm biệt!");
                    return;
                }
                default -> System.out.println("Vui lòng nhập lại!");
            }
        }
    }

    private void sortByAmountThenName() {
        System.out.println("====DANH SÁCH THEO TIỀN GIẢM DẦN, TÊN TĂNG DẦN====");
        List<Spend> list = controller.sortByAmountDescThenNameAsc();
        for (Spend spend : list) {
            display(spend);
        }
    }

    private void sortByNameAsc() {
        System.out.println("====DANH SÁCH CHI TIÊU TĂNG DẦN THEO TÊN====");
        List<Spend> list = controller.sortByNameAsc();
        for (Spend spend : list) {
            display(spend);
        }
    }

    private void searchByName() {
        System.out.println("====TÌM CHI TIÊU THEO TÊN====");
        System.out.print("Nhập tên cần tìm: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        Map<Integer, Spend> result = controller.searchByName(name);

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy chi tiêu nào khớp!");
        } else {
            System.out.println("Kết quả tìm được:");
            for (Map.Entry<Integer, Spend> entry : result.entrySet()) {
                display(entry.getValue());
            }
        }
    }


    private void searchByCode() {
        System.out.println("====TÌM CHI TIÊU THEO MÃ====");
        System.out.print("Nhập mã cần tìm: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        Spend spend = controller.searchByCode(code);
        if (spend == null) {
            System.out.println("Không tìm thấy mã này!");
        } else {
            display(spend);
        }
    }
<<<<<<< HEAD
=======
    private void findAll(){
        controller.findAll();
    }
>>>>>>> save-detached-work

    private void getAll() {
        Collection<Spend> spends = controller.getAll();
        if (spends.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            displaySpend(spends);
        }
    }

    private void add() {
        System.out.println("====THÊM CHI TIÊU====");
        System.out.print("Nhập mã chi tiêu: ");
        int code = InputExceptions.inputInterger();
        try {
            if (controller.isCodeExist(code)) {
                throw new UniqueIdException("Mã " + code + " đã tồn tại");
            }
            Spend spend = input(code);
            Spend success = controller.add(spend);
            System.out.println("Thêm thành công!");
        } catch (UniqueIdException e) {
            System.out.println(e.getMessage());
        }
    }


    private void delete() {
        System.out.println("====XOÁ CHI TIÊU====");
        System.out.print("Nhập mã chi tiêu cần xoá: ");
        int code = InputExceptions.inputInterger();
        try {
            if (!controller.isCodeExist(code)) {
                throw new IdNotFoundException("Mã bạn vừa nhập không tồn tại!");
            }
            System.out.println("Nhập y để xác nhận hoặc phím khác để huỷ: ");
            String confirm = scanner.nextLine().toLowerCase();
            if (confirm.equals("y")) {
                controller.delete(code);
                System.out.println("Xoá thành công!");
            } else {
                System.out.println("Đã huỷ thao tác!");
            }
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void update() {
        System.out.println("====SỬA CHI TIÊU====");
        System.out.print("Nhập mã cần sửa: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        if (controller.isCodeExist(code)) {
            Spend spend = input(code);
            controller.update(code, spend);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Mã không tồn tại!");
        }
    }

    public Spend input(int code) {
        System.out.println("Mã: " + code);
        System.out.print("Nhập tên chi tiêu: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày chi tiêu (yyyy/mm/dd): ");
        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.print("Nhập số tiền: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String describe = scanner.nextLine();
        return new Spend(code, name, date, amount, describe);
    }

    public void displaySpend(Collection<Spend> spends) {
        System.out.printf("%-10s %-20s %-12s %-10s %-30s\n", "Mã", "Tên", "Ngày", "Số tiền", "Mô tả");
        System.out.println("---------------------------------------------------------------------------------------");

        for (Spend spend : spends) {
            System.out.printf(
                    "%-10s %-20s %-12s %-10d %-30s\n",
                    spend.getCode(),
                    spend.getName(),
                    spend.getDate(),
                    spend.getAmount(),
                    spend.getDescribe()
            );
        }
        System.out.println("---------------------------------------------------------------------------------------");

    }

    public void display(Spend spend) {
        System.out.printf("%-10s %-20s %-12s %-10s %-30s\n", "Mã", "Tên", "Ngày", "Số tiền", "Mô tả");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf(
                "%-10s %-20s %-12s %-10d %-30s\n",
                spend.getCode(),
                spend.getName(),
                spend.getDate(),
                spend.getAmount(),
                spend.getDescribe()
        );
        System.out.println("---------------------------------------------------------------------------------------");
    }
}
