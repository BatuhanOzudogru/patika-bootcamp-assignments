package Week5.PatikaStore;

import java.util.ArrayList;
import java.util.Scanner;

public class Phone extends Product {
    private int id;
    private int batteryPower;
    private String color;
    private int camera;
    private static ArrayList<Phone> phones = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public Phone(String name, double price, double discountRate, int unitInStock, Brand brand, int memory, int ram, double screenSize, int camera, int batteryPower, String color) {
        super(name, price, discountRate, unitInStock, brand, memory, ram, screenSize);
        this.id = phones.size() + 1;
        this.camera = camera;
        this.batteryPower = batteryPower;
        this.color = color;
    }


    static {
        phones.add(new Phone("SAMSUNG GALAXY A51", 3199.0, 0.5, 5, new Brand("Samsung"), 128, 6, 6.5, 32, 4000, "Siyah"));
    }


    public static void phoneMenu() {

        System.out.println("----Cep Telefonu İşlemleri-----");
        System.out.println("1-Telefonları Listele");
        System.out.println("2-Yeni Bir Telefon Ekle");
        System.out.println("3-Mevcut Bir Telefonu Sil");
        System.out.println("0-Çıkış  Yap");
        System.out.println("--------------------------------");
        System.out.print("Bir seçim yapınız : ");
        int select = input.nextInt();
        switch (select) {
            case 1:
                printPhones();
                break;
            case 2:
                addPhone();
                System.out.println("Ürün ekleme başarılı!");
                break;
            case 3:
                deletePhone();
                phones.size();
                System.out.println("Ürün silme başarılı!");
                break;
            case 0:
                break;
        }
    }

    public static void printPhones() {
        for (Phone p : phones) {
            System.out.print("ID " + p.getId() + " ÜRÜN ADI " + p.getName() + " FİYAT " + p.getPrice() + " MARKA " + p.getBrand().getBrandName() + " DEPOLAMA " + p.getMemory() + " EKRAN " + p.getScreenSize() + " KAMERA " + p.getCamera() + " PİL " + p.getBatteryPower() + " RAM " + p.getRam() + " RENK " + p.getColor());
            System.out.println();
        }
    }

    public static void addPhone() {
        System.out.println("Ürünün adını giriniz : ");
        String name = input.next();
        System.out.println("Ürünün fiyatını giriniz : ");
        double price = input.nextDouble();
        System.out.println("Ürünün indirim oranını giriniz : ");
        double discountRate = input.nextDouble();
        System.out.println("Ürünün stok adedini giriniz : ");
        int unitInStock = input.nextInt();
        System.out.println("Lütfen telefonun markasını seçiniz : ");
        Brand.printBrands();
        int selectedBrand = input.nextInt()-1;
        System.out.println("Ürünün hafızasını(GB) giriniz : ");
        int memory = input.nextInt();
        System.out.println("Ürünün RAM'ini giriniz : ");
        int ram = input.nextInt();
        System.out.println("Ürünün ekran boyununu inç olarak giriniz : ");
        double screenSize = input.nextDouble();
        System.out.println("Ürünün kamera megapixselini giriniz : ");
        int camera = input.nextInt();
        System.out.println("Ürünün batarya gücünü giriniz : ");
        int batteryPower = input.nextInt();
        System.out.println("Ürünün rengini giriniz : ");
        String color = input.next();

        phones.add(new Phone(name, price, discountRate, unitInStock,Brand.selectBrand(selectedBrand), memory, ram, screenSize, camera, batteryPower, color));
    }
    public static void deletePhone(){
        printPhones();
        System.out.println("Hangi telefonu silmek istiyorsunuz : ");
        int selectId = input.nextInt()-1;
        phones.remove(selectId);

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Phone> getPhones() {
        return phones;
    }

    public static void setPhones(ArrayList<Phone> phones) {
        Phone.phones = phones;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
