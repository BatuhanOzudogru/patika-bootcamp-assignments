package Week1;
import java.util.Scanner;
public class DaireDilimininAlani {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //değişkenleri belirliyoruz
        double r,a,pi=3.14,dilimA;
        //kullanıcıdan değişkenlerin değerlerini alıyoruz
        System.out.print("Dairenin yarıçapını giriniz: ");
        r=input.nextDouble();
        System.out.print("Dairenin diliminin merkez açısını giriniz: ");
        a=input.nextDouble();

        //aldığımız değerlerle hesaplamaları yapıp kullanıcıya aktarıyoruz.

        dilimA=(pi*(r*r)*a)/360;
        System.out.println("Daire diliminin alanı: "+ dilimA);


    }
}
