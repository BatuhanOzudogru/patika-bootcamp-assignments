package Week5.PatikaStore;

import java.util.Scanner;

public class PatikaStore {
    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nWelcome to Patika Store!!\n");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1-Notebook Operations");
            System.out.println("2-Phone Operations");
            System.out.println("3-List Brands");
            System.out.println("0-Exit");
            System.out.println("--------------------------------");
            System.out.print("Please make a choice : ");
            int selected = input.nextInt();


            switch (selected) {
                case 1:
                    Notebook.notebookMenu();
                    break;
                case 2:
                    Phone.phoneMenu();
                    break;
                case 3:
                    Brand.printBrands();
                    System.out.println();
                    break;

                case 0:
                    showMenu = false;
                    break;
                default:
                    System.out.println("Invalid Entry");

            }

        }

    }
}
