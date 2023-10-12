package Week5.PatikaStore;

import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product {
    static Scanner input = new Scanner(System.in);

    private int id;
    private static ArrayList<Notebook> notebooks = new ArrayList<>();

    public Notebook(int id, String name, double price, double discountRate, int unitInStock, Brand brand, int storage, int ram, double screenSize) {
        super(name, price, discountRate, unitInStock, brand, storage, ram, screenSize);
        this.id = id;

    }

    static {
        notebooks.add(new Notebook(1, "HUAWEI Matebook 14", 7000, 0.5, 5, Brand.selectBrand(3), 512, 16, 14));
        notebooks.add(new Notebook(2, "Lenovo V14 IGL", 3699, 0, 5, Brand.selectBrand(1), 1024, 8, 14));
        notebooks.add(new Notebook(3, "ASUS Tuf Gaming", 8199, 0, 5, Brand.selectBrand(5), 2048, 32, 15.6));
    }


    public static void notebookMenu() {
        boolean showMenu = true;
        while(showMenu){
            System.out.println("----Notebook Operations-----");
            System.out.println("1-List all Notebooks");
            System.out.println("2-Add a New Notebook");
            System.out.println("3-Delete a Notebook");
            System.out.println("0-Exit");
            System.out.println("--------------------------------");
            System.out.print("Make a choice ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    printNotebook();
                    break;
                case 2:
                    addNotebook();
                    System.out.println("Product added successfully");
                    break;
                case 3:
                    deleteNotebook();
                    notebooks.size();
                    System.out.println("Product deleted successfully");
                    break;
                case 0:
                    showMenu=false;
                    break;
            }
        }

    }
    public static void printAllNotebooks() {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-10s    | %-10s | %-10s | %-10s | %-10s |\n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen Size", "RAM");
        System.out.println("-----------------------------------------------------------------------------------------------------------");

        for (Notebook n : notebooks) {
            System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f  | %-10d |\n",
                    n.getId(), n.getName(), n.getPrice(), n.getBrand().getBrandName(),
                    n.getStorage(), n.getScreenSize(), n.getRam());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------");

    }

    public static void filterNotebookById(int Id) {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-10s    | %-10s | %-10s | %-10s | %-10s |\n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen Size", "RAM");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        boolean a = false;
        for (Notebook n : notebooks) {
            if (n.getId() == Id) {
                System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d |\n",
                        n.getId(), n.getName(), n.getPrice(), n.getBrand().getBrandName(),
                        n.getStorage(), n.getScreenSize(), n.getRam());
                a=true;
            }
        }
        if(!a){
            System.out.println("Product ID not found");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }

    public static void filterNotebookByBrand() {
        Brand.printBrands();
        System.out.print("Please choose a brand by its number : ");
        int selectBrandNumber = input.nextInt() - 1;
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-10s    | %-10s | %-10s | %-10s | %-10s |\n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen Size", "RAM");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
         boolean a = false;
        for (Notebook n : notebooks) {
            if (n.getBrand().getBrandName().equals(Brand.filterBrand(selectBrandNumber))) {
                System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d |\n",
                        n.getId(), n.getName(), n.getPrice(), n.getBrand().getBrandName(),
                        n.getStorage(), n.getScreenSize(), n.getRam());
                a = true;
            }
        }

        if (!a) {
            System.out.println("Brand not found !");
        }


        System.out.println("-----------------------------------------------------------------------------------------------------------");


    }

    public static void printNotebook() {
        System.out.println("1-List All Notebooks");
        System.out.println("2-Filter Notebooks By ID");
        System.out.println("3-Filter Notebooks By Brand");
        System.out.print("Make a choice : ");
        int select=input.nextInt();
        switch (select){
            case 1:
               printAllNotebooks();
                break;
            case 2:
                System.out.println("Enter an ID");
                int id = input.nextInt();
                filterNotebookById(id);
                break;
            case 3:
                filterNotebookByBrand();
                break;
        }

    }

    public static void addNotebook() {
        System.out.print("Enter product name : ");
        String name = input.next()+input.nextLine();
        System.out.print("Enter product price : ");
        double price = input.nextDouble();
        System.out.print("Enter product discount rate : ");
        double discountRate = input.nextDouble();
        System.out.print("Enter product in stock : ");
        int unitInStock = input.nextInt();
        System.out.println("--------Brands--------");
        Brand.printBrands();
        System.out.print("Please choose a brand of notebook : ");
        int selectedBrand = input.nextInt() - 1;
        while(!(selectedBrand>=0&&selectedBrand<9)){
            System.out.println("Invalid entry!");
            System.out.print("Please choice a brand of notebook : ");
            selectedBrand = input.nextInt() - 1;
        }
        System.out.print("Enter product storage : ");
        int storage = input.nextInt();
        System.out.print("Enter product RAM : ");
        int ram = input.nextInt();
        System.out.print("Enter product screen size (inch) : ");
        double screenSize = input.nextDouble();


        int maxId = 0;
        for (Notebook n : notebooks) {
            if (n.getId() > maxId) {
                maxId = n.getId();
            }
        }

        // Assign the new phone an ID one integer higher than the maximum ID
        int newNotebookId = maxId + 1;

        notebooks.add(new Notebook(newNotebookId, name, price, discountRate, unitInStock, Brand.selectBrand(selectedBrand), storage, ram, screenSize));
    }

    public static void deleteNotebook() {
        printNotebook();
        System.out.print("Select notebook by ID to delete : ");
        int selectId = input.nextInt() - 1;
        notebooks.remove(selectId);

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Notebook> getNotebooks() {
        return notebooks;
    }

    public static void setNotebooks(ArrayList<Notebook> notebooks) {
        Notebook.notebooks = notebooks;
    }
}
