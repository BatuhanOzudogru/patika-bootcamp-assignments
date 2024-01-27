package Week1;

import java.util.Scanner;
public class TipDonusumleri {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tamSayi, yeniTamSayi;        //değişkenler
        double ondalikliSayi, yeniOndalikliSayi;
        System.out.print("Bir tam sayı giriniz : "); //kullanıcıdan  değerleri alıyoruz.
        tamSayi = input.nextInt();
        System.out.print("Bir ondalıklı sayı giriniz : ");
        ondalikliSayi = input.nextDouble();
        yeniOndalikliSayi = (double) tamSayi;  // tam sayının ondalıklı sayı halini yeni bir değişkene atıyoruz.
        yeniTamSayi = (int) ondalikliSayi;       // ondalıklı sayının tam sayı halini yeni bir değişkene atıyoruz.
        System.out.println("Tam sayı -> Ondalıklı sayı : " + yeniOndalikliSayi);    //yeni atadıgımız deişkenleri bastırıyoruz
        System.out.println("Ondalıklı sayı -> Tam sayı : " + yeniTamSayi);
    }
}
