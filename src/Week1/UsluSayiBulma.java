package Week1;

import java.util.Scanner;

public class UsluSayiBulma {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, k;    //değişkenleri belirliyoruz.
        int toplam = 1;

        System.out.print("Üssü Alınacak Sayıyı Giriniz : ");   //kullanıcıdan degerleri alıyoruz.
        n = input.nextInt();
        System.out.print("Üs değerini giriniz : ");
        k = input.nextInt();

        for (int i = 1; i <= k; i++) {            //for döngüsüyle üslü sayıyı hesaplıyoruz.
            toplam *= n;
        }
        System.out.println("Cevap : " + toplam);
    }
}