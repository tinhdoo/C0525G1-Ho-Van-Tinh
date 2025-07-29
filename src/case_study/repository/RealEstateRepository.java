package case_study.repository;

import case_study.entity.RealEstate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RealEstateRepository {
    public List<RealEstate> listRealEstates = new ArrayList<>();
    static String Url = "case_study/data/RealEstateData.csv";

    public void add(RealEstate realEstate) {
        listRealEstates.add(realEstate);
        File file = new File(Url);
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String line = realEstate.getCode() + "," + realEstate.getName() + "," + realEstate.getType() + "," +
                    realEstate.getLocation() + "," + realEstate.getArea() + "," +
                    realEstate.getPrice() + "," + realEstate.isSold();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file!");
        }
    }
    public void findAll() {
        List<RealEstate> list = readFromFile();
        for (RealEstate r : list) {
            System.out.println(r);
        }
    }
    public List<RealEstate> readFromFile() {
        List<RealEstate> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Url))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length == 7) {
                    RealEstate r = new RealEstate(
                            Integer.parseInt(arr[0]),
                            arr[1],
                            arr[2],
                            arr[3],
                            Double.parseDouble(arr[4]),
                            Double.parseDouble(arr[5]),
                            Boolean.parseBoolean(arr[6])
                    );
                    list.add(r);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file!");
        }
        return list;
    }
    public void delete(int code) {
        List<RealEstate> list = readFromFile();
        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
            RealEstate r = list.get(i);
            if (r.getCode() == code) {
                list.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(Url))) {
                for (RealEstate r : list) {
                    String line = r.getCode() + "," + r.getName() + "," + r.getType() + "," +
                            r.getLocation() + "," + r.getArea() + "," +
                            r.getPrice() + "," + r.isSold();
                    bw.write(line);
                    bw.newLine();
                }
                System.out.println("Đã xoá bất động sản có mã: " + code);
            } catch (IOException e) {
                System.out.println("Lỗi khi ghi lại file!");
            }
        } else {
            System.out.println("Không tìm thấy mã: " + code);
        }
    }
}

