package case_study.entity;

public class Cart extends RealEstate{
    public Cart() {
    }

    public Cart(int code, String name, String type, String location, double area, double price) {
        super(code, name, type, location, area, price);
    }
}
