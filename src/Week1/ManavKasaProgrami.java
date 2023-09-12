package Week1;

import java.util.Scanner;
public class ManavKasaProgrami {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Değişkenlerimizi tanımlıyoruz.
        double armutTl=2.14,armutKg,elmaTl=3.67,elmaKg,domatesTl=1.11,domatesKg,muzTl=0.95,muzKg,
                patlicanTl=5.0,patlicanKg,toplamTutar;
        //kullanıcıdan değişkenlerin değerlerini alıyoruz
        System.out.print("Armut Kaç Kilo ? : ");
        armutKg=input.nextDouble();
        System.out.print("Elma Kaç Kilo ? : ");
        elmaKg=input.nextDouble();
        System.out.print("Domates Kaç Kilo ? : ");
        domatesKg=input.nextDouble();
        System.out.print("Muz Kaç Kilo ? : ");
        muzKg=input.nextDouble();
        System.out.print("Patlıcan Kaç Kilo ? :");
        patlicanKg=input.nextDouble();

        /*Kullanıcıdan aldığımız kilo değerleriyle,
        birimlerin kilo başına olan fiyatlarını çarpıp kullınıcıya sunuyoruz.*/

        toplamTutar=(armutTl*armutKg)+(elmaTl*elmaKg)+(domatesTl*domatesKg)+(muzTl*muzKg)+
                (patlicanKg*patlicanTl);
        System.out.println("Toplam Tutar : "+toplamTutar+" TL");

    }
}
