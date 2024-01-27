package Week5.PatikaStore;
import java.util.*;

public class Brand  {
    private int id;
    private String brandName;
    private static ArrayList<Brand> brands = new ArrayList<>();
    public Brand(int id, String brandName, ArrayList<Brand> brandList) {
        this.id = id;
        this.brandName = brandName;
        this.brands = brandList;
    }

    public Brand(String brandName){
        this.id=brands.size();
        this.brandName=brandName;
    }
    static {
        brands.add(new Brand("Samsung"));
        brands.add(new Brand("Lenovo"));
        brands.add(new Brand("Apple"));
        brands.add(new Brand("Huawei"));
        brands.add(new Brand("Casper"));
        brands.add(new Brand("Asus"));
        brands.add(new Brand("HP"));
        brands.add(new Brand("Xiaomi"));
        brands.add(new Brand("Monster"));
    }

    public int getID() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public static void printBrands(){
        Collections.sort(brands,Comparator.comparing(Brand::getBrandName));
        int id=0;
        for(Brand b : brands){
            id++;
            System.out.println(id+". "+b.brandName);

        }


    }
    public static Brand selectBrand(int x){
        Collections.sort(brands,Comparator.comparing(Brand::getBrandName));
        return brands.get(x);
    }
    public static String filterBrand(int x){
        return brands.get(x).getBrandName();
    }


}