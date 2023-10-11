package Week5.PatikaStore;

import java.util.Scanner;

public class PatikaStore {
    public void start(){
        System.out.println("Hoşgeldiniz");
        Scanner input = new Scanner(System.in);
        System.out.println("Patika Store Hoşgeldiniz.");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1-Notebook İşlemleri");
            System.out.println("2-Cep Telefonu İşlemleri");
            System.out.println("3-Marka Listele");
            System.out.println("0-Çıkış  Yap");
            System.out.println("--------------------------------");
            System.out.print("Bir seçim yapınız : ");
            System.out.println();

            int selected = input.nextInt();


            switch (selected) {
                case 1:
                    System.out.println("1-Notebook İşlemleri");
                    break;
                case 2:
                    Phone.phoneMenu();
                    break;
                case 3:
                    Brand.printBrands();
                    System.out.println();
                    break;

                case 0:
                    System.out.println("0-Çıkış  Yap");
                    showMenu = false;
                    break;
                default:
                    System.out.println("Yanlış tuşlama yaptınız !!!");

            }

        }

    }
}
