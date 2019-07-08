package fourthDay.homeWork;

public class Phone {

    private String brand;
    private String id;
    private Double price;
    private String size;
    private String color;

    public Phone(String brand, String id, Double price, String size, String color) {
        //this();
        this(brand,id);
        this.brand = brand;
        this.id = id;
        this.price = price;
        this.size = size;
        this.color = color;
    }

    public Phone(){
        System.out.println("无参构造器========");
    }

    public Phone(String brand, String id){
        System.out.println("两个参数构造器==========");
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
