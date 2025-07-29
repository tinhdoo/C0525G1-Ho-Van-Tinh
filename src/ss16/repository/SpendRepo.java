package ss16.repository;

import ss16.entity.Spend;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class SpendRepo {
    public Map<Integer, Spend> listSpend = new HashMap<>();

    private static final String FILE_PATH = "src/ss16/data/writerll.csv";
    public SpendRepo() {
        loadFromFile();
    }
    public void add(Spend spend) {
        listSpend.put(spend.getCode(), spend);
        File file = new File(FILE_PATH);
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            String line = String.join(",", spend.getCode() + "", spend.getName(), spend.getDate().toString(), spend.getAmount() + "", spend.getDescribe());
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi đọc ghi: " + e.getMessage());
        }
    }

    public void findAll() {
        try (FileReader fileReader = new FileReader(FILE_PATH);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file!");
        }
    }
    public void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int code = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    LocalDate date = LocalDate.parse(parts[2]);
                    int amount = Integer.parseInt(parts[3]);
                    String description = parts[4];
                    listSpend.put(code, new Spend(code, name, date, amount, description));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }


    public Collection<Spend> getAll() {
        return listSpend.values();
    }

    public void delete(int code) {
        listSpend.remove(code);
    }

    public void update(int code, Spend spend) {
        listSpend.replace(code, spend);
    }

    public Spend searchByCode(int code) {
        return listSpend.get(code);
    }

    public Map<Integer, Spend> searchByName(String name) {
        Map<Integer, Spend> result = new HashMap<>();
        for (Map.Entry<Integer, Spend> entry : listSpend.entrySet()) {
            if (entry.getValue().getName().toLowerCase().contains(name.toLowerCase())) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public List<Spend> sortByNameAsc() {
        List<Spend> sortedList = new ArrayList<>(listSpend.values());
        sortedList.sort(Comparator.comparing(Spend::getName));
        return sortedList;
    }

    public List<Spend> sortByAmountDescThenNameAsc() {
        List<Spend> sortedList = new ArrayList<>(listSpend.values());
        sortedList.sort(Comparator.comparing(Spend::getAmount).reversed().thenComparing(Spend::getName));
        return sortedList;
    }

    public boolean isCodeExist(int code) {
        return listSpend.containsKey(code);
    }
}
