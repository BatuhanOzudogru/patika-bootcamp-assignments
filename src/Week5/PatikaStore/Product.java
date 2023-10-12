package Week5.PatikaStore;

import java.util.ArrayList;

public abstract class Product {
    private int id;
    private String name;
    private double price;
    private double discountRate;
    private int unitInStock;
    private Brand brand;
    private int memory;
    private int ram;
    private double screenSize;
    private static ArrayList<Product> products = new ArrayList<>();

    public Product(String name, double price, double discountRate, int unitInStock, Brand brand, int memory, int ram, double screenSize) {
        this.id=products.size()+1;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.unitInStock = unitInStock;
        this.brand = brand;
        this.memory = memory;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        Product.products = products;
    }
}
