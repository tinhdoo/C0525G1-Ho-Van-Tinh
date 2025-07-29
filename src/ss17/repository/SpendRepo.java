package ss17.repository;

import ss17.entity.Spend;

import java.io.*;
import java.util.*;

public class SpendRepo {
    public List<Spend> listSpend = new ArrayList<>();
    static String Url = "ss17/data/data.csv";

    public SpendRepo() {
        listSpend = readFromFile();
    }

    public void add(Spend spend) {
        listSpend.add(spend);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Url))) {
            oos.writeObject(listSpend);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file!");
        }
    }

    public List<Spend> readFromFile() {
        List<Spend> list = new ArrayList<>();
        File file = new File(Url);
        if (!file.exists()) return list;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<Spend>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy lớp khi đọc dữ liệu từ file !");
        }
        return list;
    }


    public Collection<Spend> getAll() {
        return listSpend;
    }

    public void delete(int code) {
        listSpend.removeIf(s -> s.getCode() == code);
        writeToFile();
    }

    public void update(int code, Spend newSpend) {
        for (int i = 0; i < listSpend.size(); i++) {
            if (listSpend.get(i).getCode() == code) {
                listSpend.set(i, newSpend);
                break;
            }
        }
        writeToFile();
    }

    public void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Url))) {
            oos.writeObject(listSpend);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file!");
        }
    }

    public Spend searchByCode(int code) {
        Spend spend = listSpend.get(code);
        return spend;
    }

    public Map<Integer, Spend> searchByName(String name) {
        Map<Integer, Spend> result = new HashMap<>();
        for (Spend spend : listSpend) {
            if (spend.getName().toLowerCase().contains(name.toLowerCase())) {
                result.put(spend.getCode(), spend);
            }
        }
        return result;
    }

    public List<Spend> sortByNameAsc() {
        List<Spend> sortedList = new ArrayList<>(listSpend);

        sortedList.sort(Comparator.comparing(Spend::getName));

        return sortedList;
    }
    public boolean isCodeExist(int code) {
        for (Spend spend : listSpend) {
            if (spend.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    public List<Spend> sortByAmountDescThenNameAsc() {
        List<Spend> sortedList = new ArrayList<>(listSpend);
        sortedList.sort(Comparator.comparing(Spend::getAmount).reversed().thenComparing(Spend::getName));
        return sortedList;
    }
}
