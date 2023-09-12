package Week1;

import java.util.Scanner;

public class TaksimetreHesaplama {
    public static void main(String[] args) {
        double herKm=2.2,gidilenKm,taksimetreTutari,baslangicUcreti=10;
        Scanner input = new Scanner(System.in);

        System.out.print("Gidilen KM'yi yazınız: ");
        gidilenKm= input.nextDouble();
        //gidilenkm yazılacak

        taksimetreTutari=(gidilenKm*herKm)+baslangicUcreti;
        taksimetreTutari=(taksimetreTutari<20) ? 20 : taksimetreTutari;
        System.out.println("Toplam Tutar: "+ taksimetreTutari);

    }
}
