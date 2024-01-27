package Week5.PatikaStore;

public abstract class Product {
    private int id;
    private String name;
    private double price;
    private double discountRate;
    private int unitInStock;
    private Brand brand;
    private int storage;
    private int ram;
    private double screenSize;
    //private static ArrayList<Product> products = new ArrayList<>();

    public Product(String name, double price, double discountRate, int unitInStock, Brand brand, int storage, int ram, double screenSize) {
        //this.id=products.size()+1;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.unitInStock = unitInStock;
        this.brand = brand;
        this.storage = storage;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getStorage() {
        return storage;
    }

    public int getRam() {
        return ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

}
