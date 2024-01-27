package Week1;
import java.util.Scanner;
public class VucutKitleIndeksiHesaplama {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //değişkenlerimizi tanımlıyoruz.
        double boy,kilo,indeks;

        //kullanıcıdan değişkenlerin değerlerini alıyoruz

        System.out.print("Lütfen boyunuzu (metre cindinde) giriniz : ");
        boy=input.nextDouble();
        System.out.print("Lütfen kilonuzu giriniz : ");
        kilo=input.nextDouble();
        //Alınan değerler ile hesaplamayı yapıp kullanıcıya yansıtıyoruz.
        indeks= kilo/(boy*boy);
        System.out.print("Vücut Kitle İndeksiniz : "+ indeks);




    }
}
