package ss17.repository;

import ss17.entity.Spend;

import java.io.*;
import java.util.*;

public class SpendRepo {
    public List<Spend> listSpend;
    static String Url = "src/ss17/data/data.txt";

    public SpendRepo() {
        listSpend = readFromFile();
    }

    public void add(Spend spend) {
        listSpend.add(spend);
        writeToFile();
    }
    @SuppressWarnings("unchecked")
    public List<Spend> readFromFile() {
        List<Spend> list = new ArrayList<>();
        File file = new File(Url);
        if (!file.exists() || file.length() == 0) return list;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            list = (List<Spend>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
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
        for (Spend spend : listSpend) {
            if (spend.getCode() == code) {
                return spend;
            }
        }
        return null;
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
