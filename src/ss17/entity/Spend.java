package ss17.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Spend implements Serializable {
    private int code;
    private String  name;
    private LocalDate date;
    private int amount;
    private String describe;

    public Spend(int code, String name, LocalDate date, int amount, String describe) {
        this.code = code;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.describe = describe;
    }
    public Spend() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Spend{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", describe='" + describe + '\'' +
                '}';
    }
}
