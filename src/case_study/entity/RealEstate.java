package case_study.entity;

public class RealEstate {
    private int code;
    private String name;
    private String type;
    private String location;
    private double area;
    private double price;
    private boolean isSold;

    public RealEstate(int code, String name, String type, String location, double area, double price) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public RealEstate(int code, String name, String type, String location, double area, double price, boolean isSold) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.location = location;
        this.area = area;
        this.price = price;
        this.isSold = isSold;
    }

    public RealEstate() {
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", isSold=" + isSold +
                '}';
    }
}
