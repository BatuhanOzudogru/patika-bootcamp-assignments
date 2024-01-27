package Week1;
import java.util.Scanner;
public class UcgenAlanBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Değişkenlerimizi tanımlıyoruz
        double aKenari,bKenari,cKenari,u,ucgenAlan;
        //Kullanıcıdan üçgenin kenar uzunluklarını alıyoruz
        System.out.print("a kenar uzunluğunu giriniz: ");
        aKenari=input.nextDouble();
        System.out.print("b kenar uzunluğunu giriniz: ");
        bKenari=input.nextDouble();
        System.out.print("c kenar uzunluğunu giriniz: ");
        cKenari=input.nextDouble();

        //Üçgenin çevresini ve alanını hesaplayıp kullanıcıya sunuyoruz.
        u=(aKenari+bKenari+cKenari)/2;
        ucgenAlan =Math.sqrt (u*(u-aKenari)*(u-bKenari)*(u-cKenari));
        System.out.println("Üçgenin Alanı : " + ucgenAlan);
    }
}